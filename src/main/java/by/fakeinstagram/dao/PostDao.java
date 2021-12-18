package by.fakeinstagram.dao;

import by.fakeinstagram.constants.Constants;
import by.fakeinstagram.entity.Post;
import by.fakeinstagram.entity.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PostDao {
    private final UserDao userDao = new UserDao();
    private final DateTimeConverter dateTimeConverter = new DateTimeConverter();

    public Post createPost(User user, Post post) {//работает
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD)) {
            PreparedStatement insertPost = connection.prepareStatement(Constants.INSERT_POST);

            insertPost.setString(1, post.getTitle());
            insertPost.setString(2, post.getDescription());
            insertPost.setString(3, dateTimeConverter.localDateTimeToString(LocalDateTime.now()));
            insertPost.setLong(4, user.getId());
            insertPost.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public void deletePost(long postId) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement deletePost = connection.prepareStatement(Constants.DELETE_POST)) { //"DELETE FROM posts WHERE id=?"
            connection.setAutoCommit(false);
            try {
                deletePost.setLong(1, postId);
                deletePost.executeUpdate();
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Post> findPostById(long id) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectPostById = connection.prepareStatement(Constants.SELECT_POST_BY_ID)) {//"SELECT * FROM posts WHERE id=?"
            selectPostById.setLong(1, id);
            ResultSet resultSet = selectPostById.executeQuery();
            if (resultSet.next()) {
                Post post = new Post(
                        resultSet.getLong("id"),
                        userDao.findUserById(resultSet.getLong("user_id")).get(),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        dateTimeConverter.stringToLocalDateTime(resultSet.getString("dateOfCreation"))
                );
                resultSet.close();
                return Optional.of(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Post> findPostByUserId(long id) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectPostById = connection.prepareStatement(Constants.SELECT_POST_BY_USERID)) {//"SELECT * FROM posts WHERE user_id=?"
            selectPostById.setLong(1, id);
            ResultSet resultSet = selectPostById.executeQuery();
            if (resultSet.next()) {
                Post post = new Post(
                        resultSet.getLong("id"),
                        userDao.findUserById(resultSet.getLong("user_id")).get(),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        dateTimeConverter.stringToLocalDateTime(resultSet.getString("dateOfCreation"))
                );
                resultSet.close();
                return Optional.of(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public List<Post> getAllPosts() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy, MM, dd HH:mm:ss");
        List<Post> postList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD)) {
            Statement getAllPosts = connection.createStatement();

            ResultSet allPosts = getAllPosts.executeQuery(Constants.SELECT_ALL_POST);
            while (allPosts.next()) {
                postList.add(new Post(
                        allPosts.getLong("id"),
                        userDao.findUserById(allPosts.getLong("user_id")).get(),
                        allPosts.getString("title"),
                        allPosts.getString("description"),
                        dateTimeConverter.stringToLocalDateTime(allPosts.getString("dateOfCreation"))
                ));
            }
            return postList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updatePost(Post post) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement updatePost = connection.prepareStatement(Constants.UPDATE_POST)) {//SET title=?, description=? WHERE id=?
            updatePost.setString(1, post.getTitle());
            updatePost.setString(2, post.getDescription());
            updatePost.setLong(3, post.getId());
            updatePost.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
