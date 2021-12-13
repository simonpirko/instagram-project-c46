package by.fakeinstagram.service;

import by.fakeinstagram.dao.PostDao;
import by.fakeinstagram.dao.UserDao;
import by.fakeinstagram.entity.Post;
import by.fakeinstagram.entity.User;

public class PostService {
    PostDao postDao = new PostDao();

    public Post createPost(User user, Post post){
        return postDao.createPost(user,post);
    }

    public void updatePost(Post post){
        postDao.updatePost(post);
    }

    public void deletePost(long id){
        postDao.deletePost(id);
    }

}
