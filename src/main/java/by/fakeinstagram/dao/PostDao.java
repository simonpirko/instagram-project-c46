package by.fakeinstagram.dao;

import by.fakeinstagram.constants.Constants;
import by.fakeinstagram.entity.Post;
import by.fakeinstagram.entity.User;

import java.sql.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public class PostDao {
    public Post createPost(User user, Post post) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement insertPost = connection.prepareStatement(Constants.INSERT_POST)) {//"INSERT INTO posts (title,description,dateOfCreation,user_id) VALUES (?, ?, ?, ?)";
            connection.setAutoCommit(false);

            insertPost.setString(1, post.getTitle());
            insertPost.setString(2, post.getDescription());
            insertPost.setDate(3, (java.sql.Date) convertToDateViaInstant(post.getDateOfCreation()));
            insertPost.setLong(4, user.getId());
            insertPost.executeUpdate();

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
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("dateOfCreation").toLocalDateTime()
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
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("dateOfCreation").toLocalDateTime()
                );
                resultSet.close();
                return Optional.of(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //скорее в сего тут куча нюансов
    public List<Post> getAllPosts() {
        List<Post> postList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement getAllPosts = connection.prepareStatement(Constants.SELECT_ALL_POST)) {
            ResultSet allPosts = getAllPosts.executeQuery();
            while (allPosts.next()){
                postList.add(new Post(
                        allPosts.getLong("id"),
                        allPosts.getString("title"),
                        allPosts.getString("description"),
                        allPosts.getTimestamp("dateOfCreation").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public void updatePost(Post post) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement updatePost = connection.prepareStatement(Constants.UPDATE_POST)) {//SET title=?, description=? ,dateOfCreation=? WHERE id=?
            updatePost.setString(1, post.getTitle());
            updatePost.setString(2, post.getDescription());
            updatePost.setDate(3, (java.sql.Date) convertToDateViaInstant(post.getDateOfCreation()));
            updatePost.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return Date.from(dateToConvert.atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
