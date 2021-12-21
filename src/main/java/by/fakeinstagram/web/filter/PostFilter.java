package by.fakeinstagram.web.filter;

import by.fakeinstagram.entity.Post;
import by.fakeinstagram.entity.User;
import by.fakeinstagram.service.PostService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"PostFilter"}, urlPatterns = {"/deletepost", "/editpost"})
public class PostFilter extends HttpFilter {
    PostService postService;

    @Override
    public void init() throws ServletException {
        postService = new PostService();
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        long id = Long.parseLong(req.getParameter("id"));
        Post post = postService.getPostById(id).get();

        if (user.getId() == post.getUser().getId()) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/feed");
        }
    }
}
