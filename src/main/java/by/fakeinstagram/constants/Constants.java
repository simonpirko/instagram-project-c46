package by.fakeinstagram.constants;

public class Constants {
    public static final String SQL_DB = "jdbc:mysql://localhost:3306/fake_instagram";
    public static final String SQL_DB_USER = "root";
    public static final String SQL_DB_PASSWORD = "root";
    public static final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    public static final String INSERT_USER = "INSERT INTO users (user_name, email, password) VALUES (?, ?, ?)";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id=?";
    public static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE user_name=?";
    public static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email=? and password=?";
    public static final String UPDATE_USER = "UPDATE users SET user_name=?, email=?, password=? WHERE id=?";
    public static final String DELETE_USER = "DELETE FROM users WHERE id=?";

    public static final String INSERT_USER_DETAILS = "INSERT INTO user_details (first_name, last_name, birth_date, country, biography, user_id) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_USER_DETAILS_BY_USER_ID = "SELECT * FROM user_details WHERE user_id=?";
    public static final String UPDATE_USER_DETAILS = "UPDATE user_details SET first_name=?, last_name=?, birth_date=?, country=?, biography=? WHERE user_id=?";
}
