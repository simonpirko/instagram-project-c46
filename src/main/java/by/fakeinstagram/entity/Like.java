package by.fakeinstagram.entity;

import java.util.List;

public class Like {

    private long id;
    private boolean isActive;
    private List<User> userList;
    private int likeCounter;

    public Like() {
    }

    public Like(long id, boolean isActive, List<User> userList, int likeCounter) {
        this.id = id;
        this.isActive = isActive;
        this.userList = userList;
        this.likeCounter = likeCounter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }
}
