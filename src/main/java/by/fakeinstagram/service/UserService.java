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

    public boolean checkUser(User user) {
        return userDao.checkUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }
}
