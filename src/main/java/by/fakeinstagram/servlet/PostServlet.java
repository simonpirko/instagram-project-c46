package by.fakeinstagram.servlet;

import by.fakeinstagram.dao.PostDao;
import by.fakeinstagram.entity.Post;
import by.fakeinstagram.entity.User;
import by.fakeinstagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/post", name = "PostServlet")
public class PostServlet extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Post post = (Post) req.getSession().getAttribute("post");
        getServletContext().getRequestDispatcher("/pages/post.jsp").forward(req, resp);
        req.setAttribute("post", postService.getPostById(post.getId()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
