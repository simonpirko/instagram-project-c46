package by.fakeinstagram.entity;

import java.time.LocalDateTime;

public class Comment {

    private long id;
    private User user;
    private LocalDateTime dateOfComment;
    private String commentText;
    private int commentCounter;

    public Comment() {
    }

    public Comment(long id, User user, LocalDateTime dateOfComment, String commentText, int commentCounter) {
        this.id = id;
        this.user = user;
        this.dateOfComment = dateOfComment;
        this.commentText = commentText;
        this.commentCounter = commentCounter;
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

    public LocalDateTime getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(LocalDateTime dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getCommentCounter() {
        return commentCounter;
    }

    public void setCommentCounter(int commentCounter) {
        this.commentCounter = commentCounter;
    }
}
