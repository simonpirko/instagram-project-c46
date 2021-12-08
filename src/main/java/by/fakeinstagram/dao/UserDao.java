package by.fakeinstagram.dao;

import by.fakeinstagram.constants.Constants;
import by.fakeinstagram.entity.User;

import java.sql.*;
import java.util.Optional;

public class UserDao {

    public User createUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
            connection.setAutoCommit(false);
            PreparedStatement insertUser = connection.prepareStatement(Constants.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertUserDetails = connection.prepareStatement(Constants.INSERT_USER_DETAILS);

            insertUser.setString(1, user.getUserName());
            insertUser.setString(2, user.getEmail());
            insertUser.setString(3, user.getPassword());

            fillingUserDetailsFields(user, insertUser, insertUserDetails);
            insertUserDetails.setLong(6, insertUser.getGeneratedKeys().getLong("id"));
            insertUserDetails.executeUpdate();
            user.setId(insertUser.getGeneratedKeys().getLong("id"));

            connection.commit();
            insertUser.close();
            insertUserDetails.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }

        return user;
    }

    public Optional<User> findUserById(long id) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectUserById = connection.prepareStatement(Constants.SELECT_USER_BY_ID)) {

            selectUserById.setLong(1, id);
            Optional<User> resultSet = getUser(connection, selectUserById);
            if (resultSet.isPresent()) return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> findUserByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectUserByUsername = connection.prepareStatement(Constants.SELECT_USER_BY_USERNAME)) {

            selectUserByUsername.setString(1, username);
            Optional<User> resultSet = getUser(connection, selectUserByUsername);
            if (resultSet.isPresent()) return resultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean checkUser(User user) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectUserByEmailAndPassword = connection.prepareStatement(Constants.SELECT_USER_BY_EMAIL_AND_PASSWORD)) {

            selectUserByEmailAndPassword.setString(1, user.getEmail());
            selectUserByEmailAndPassword.setString(2, user.getPassword());

            ResultSet resultSet = selectUserByEmailAndPassword.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void updateUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
            connection.setAutoCommit(false);
            PreparedStatement updateUser = connection.prepareStatement(Constants.UPDATE_USER);
            PreparedStatement updateUserDetails = connection.prepareStatement(Constants.UPDATE_USER_DETAILS);

            try {

                updateUser.setString(1, user.getUserName());
                updateUser.setString(2, user.getEmail());
                updateUser.setString(3, user.getPassword());
                updateUser.setLong(4, user.getId());

                fillingUserDetailsFields(user, updateUser, updateUserDetails);
                updateUserDetails.setLong(6, user.getId());
                updateUserDetails.executeUpdate();

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
            updateUser.close();
            updateUserDetails.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long userId) {
        try {
            Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
            connection.setAutoCommit(false);
            PreparedStatement deleteUser = connection.prepareStatement(Constants.DELETE_USER);

            try {
                deleteUser.setLong(1, userId);
                deleteUser.executeUpdate();

                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }

            deleteUser.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Optional<User> getUser(Connection connection, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Optional.of(new User(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("birth_date").toLocalDate(),
                    resultSet.getString("user_name"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("country"),
                    resultSet.getString("biography")
            ));
        }

        resultSet.close();
        connection.commit();
        return Optional.empty();
    }

    private void fillingUserDetailsFields(User user, PreparedStatement userStatement, PreparedStatement userDetailsStatement) throws SQLException {
        userStatement.executeUpdate();

        userDetailsStatement.setString(1, user.getFirstName());
        userDetailsStatement.setString(2, user.getLastName());
        userDetailsStatement.setDate(3, Date.valueOf(user.getBirthDate()));
        userDetailsStatement.setString(4, user.getCountry());
        userDetailsStatement.setString(5, user.getBiography());
    }
}