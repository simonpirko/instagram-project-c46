package by.fakeinstagram.dao;

import by.fakeinstagram.constants.Constants;
import by.fakeinstagram.entity.User;

import java.sql.*;
import java.util.Optional;

public class UserDao {

    public User createUser(User user) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD)) {
            connection.setAutoCommit(false);
            PreparedStatement insertUser = connection.prepareStatement(Constants.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertUserDetails = connection.prepareStatement(Constants.INSERT_USER_DETAILS);

            insertUser.setString(1, user.getUserName());
            insertUser.setString(2, user.getEmail());
            insertUser.setString(3, user.getPassword());
            insertUser.executeUpdate();
            ResultSet resultSet = insertUser.getGeneratedKeys();
            long generatedKey = -1;
            if (resultSet.next()) {
                generatedKey = resultSet.getLong(1);
            }
            insertUserDetails.setString(1, user.getFirstName());
            insertUserDetails.setString(2, user.getLastName());
            insertUserDetails.setDate(3, Date.valueOf(user.getBirthDate()));
            insertUserDetails.setString(4, user.getCountry());
            insertUserDetails.setString(5, user.getBiography());
            insertUserDetails.setLong(6, insertUser.getGeneratedKeys().getLong("id"));
            insertUserDetails.executeUpdate();

            user.setId(insertUser.getGeneratedKeys().getLong("id"));

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Optional<User> findUserById(long id) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectUserById = connection.prepareStatement(Constants.SELECT_USER_BY_ID);
             PreparedStatement selectUserDetailsByUserId = connection.prepareStatement(Constants.SELECT_USER_DETAILS_BY_USER_ID)) {

            selectUserById.setLong(1, id);
            ResultSet userResultSet = selectUserById.executeQuery();

            if (userResultSet.next()) {
                long userId = userResultSet.getLong("id");
                User user = new User(
                        userId,
                        userResultSet.getString("user_name"),
                        userResultSet.getString("email"),
                        userResultSet.getString("password")
                );
                selectUserDetailsByUserId.setLong(1, userId);
                ResultSet userDetailsResultSet = selectUserDetailsByUserId.executeQuery();

                if (userDetailsResultSet.next()) {
                    user.setFirstName(userDetailsResultSet.getString("first_name"));
                    user.setLastName(userDetailsResultSet.getString("last_name"));
                    user.setBirthDate(userDetailsResultSet.getDate("birth_date").toLocalDate());
                    user.setCountry(userDetailsResultSet.getString("country"));
                    user.setBiography(userDetailsResultSet.getString("biography"));
                    return Optional.of(user);
                }
            }

            connection.commit();
            userResultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> findUserByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectUserByUsername = connection.prepareStatement(Constants.SELECT_USER_BY_USERNAME);
             PreparedStatement selectUserDetailsByUserId = connection.prepareStatement(Constants.SELECT_USER_DETAILS_BY_USER_ID)) {

            selectUserByUsername.setString(1, username);
            ResultSet userResultSet = selectUserByUsername.executeQuery();

            if (userResultSet.next()) {
                long userId = userResultSet.getLong("id");
                User user = new User(
                        userId,
                        userResultSet.getString("user_name"),
                        userResultSet.getString("email"),
                        userResultSet.getString("password")
                );
                selectUserDetailsByUserId.setLong(1, userId);
                ResultSet userDetailsResultSet = selectUserDetailsByUserId.executeQuery();

                if (userDetailsResultSet.next()) {
                    user.setFirstName(userDetailsResultSet.getString("first_name"));
                    user.setLastName(userDetailsResultSet.getString("last_name"));
                    user.setBirthDate(userDetailsResultSet.getDate("birth_date").toLocalDate());
                    user.setCountry(userDetailsResultSet.getString("country"));
                    user.setBiography(userDetailsResultSet.getString("biography"));
                    return Optional.of(user);
                }
            }

            connection.commit();
            userResultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD);
             PreparedStatement selectUserByEmailAndPassword = connection.prepareStatement(Constants.SELECT_USER_BY_EMAIL_AND_PASSWORD);
             PreparedStatement selectUserDetailsByUserId = connection.prepareStatement(Constants.SELECT_USER_DETAILS_BY_USER_ID)) {

            selectUserByEmailAndPassword.setString(1, email);
            selectUserByEmailAndPassword.setString(2, password);
            ResultSet userResultSet = selectUserByEmailAndPassword.executeQuery();

            if (userResultSet.next()) {
                long userId = userResultSet.getLong("id");
                User user = new User(
                        userId,
                        userResultSet.getString("user_name"),
                        userResultSet.getString("email"),
                        userResultSet.getString("password")
                );
                selectUserDetailsByUserId.setLong(1, userId);
                ResultSet userDetailsResultSet = selectUserDetailsByUserId.executeQuery();

                if (userDetailsResultSet.next()) {
                    user.setFirstName(userDetailsResultSet.getString("first_name"));
                    user.setLastName(userDetailsResultSet.getString("last_name"));
                    user.setBirthDate(userDetailsResultSet.getDate("birth_date").toLocalDate());
                    user.setCountry(userDetailsResultSet.getString("country"));
                    user.setBiography(userDetailsResultSet.getString("biography"));
                    return Optional.of(user);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public void updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD)) {
            connection.setAutoCommit(false);
            PreparedStatement updateUser = connection.prepareStatement(Constants.UPDATE_USER);
            PreparedStatement updateUserDetails = connection.prepareStatement(Constants.UPDATE_USER_DETAILS);

                updateUser.setString(1, user.getUserName());
                updateUser.setString(2, user.getEmail());
                updateUser.setString(3, user.getPassword());
                updateUser.setLong(4, user.getId());

                updateUserDetails.setString(1, user.getFirstName());
                updateUserDetails.setString(2, user.getLastName());
                updateUserDetails.setDate(3, Date.valueOf(user.getBirthDate()));
                updateUserDetails.setString(4, user.getCountry());
                updateUserDetails.setString(5, user.getBiography());
                updateUserDetails.setLong(6, user.getId());
                updateUserDetails.executeUpdate();

                connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long userId) {
        try (Connection connection = DriverManager.getConnection(Constants.SQL_DB, Constants.SQL_DB_USER, Constants.SQL_DB_PASSWORD)){
            connection.setAutoCommit(false);
            PreparedStatement deleteUser = connection.prepareStatement(Constants.DELETE_USER);
                deleteUser.setLong(1, userId);
                deleteUser.executeUpdate();

                connection.commit();
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

    private void fillingUserDetailsFields(User user, PreparedStatement userDetailsStatement) throws SQLException {

    }
}
