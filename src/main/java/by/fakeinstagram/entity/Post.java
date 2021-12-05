package by.fakeinstagram.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Post {

    private long id;
    private User user;
    private String title;
    private String description;
    private List<Comment> commentList;
    private Like like;
    private LocalDateTime dateOfCreation;

    public Post() {
    }

    public Post(long id, User user, String title, String description, List<Comment> commentList, Like like, LocalDateTime dateOfCreation) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.description = description;
        this.commentList = commentList;
        this.like = like;
        this.dateOfCreation = dateOfCreation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Like getLike() {
        return like;
    }

    public void setLike(Like like) {
        this.like = like;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
