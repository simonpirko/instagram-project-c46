package by.fakeinstagram.service;

import by.fakeinstagram.dao.PostDao;
import by.fakeinstagram.dao.UserDao;
import by.fakeinstagram.entity.Post;
import by.fakeinstagram.entity.User;

import java.util.List;
import java.util.Optional;

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

    public Optional<Post> getPostById(long id){
        return postDao.findPostById(id);
    }

    public Optional<Post> getPostByUserId(long id){
        return postDao.findPostByUserId(id);
    }

    public List<Post> getAllPosts(){
        return postDao.getAllPosts();
    }

}
