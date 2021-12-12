package by.fakeinstagram.service;

import by.fakeinstagram.dao.UserDao;
import by.fakeinstagram.entity.User;

import java.util.Optional;

public class UserService {
    private final UserDao userDao = new UserDao();

    public Optional<User> createUser(User user) {
        if (userDao.findUserByUsername(user.getUserName()).isEmpty())
            return Optional.of(userDao.createUser(user));
        return Optional.empty();
    }

    public Optional<User> findUserById(long id) {
        return userDao.findUserById(id);
    }

    public Optional<User> findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return userDao.findUserByEmailAndPassword(email , password);
    }

    public boolean checkUser(String email, String password) {
        return userDao.findUserByEmailAndPassword(email, password).isPresent();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void updateUserProfile(User user) {
        userDao.updateUserProfile(user);
    }

    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }
}
