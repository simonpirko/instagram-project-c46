package by.fakeinstagram.servlet;

import by.fakeinstagram.entity.Post;
import by.fakeinstagram.entity.User;
import by.fakeinstagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/deletepost", name = "DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/deletePost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long postId = Long.parseLong(req.getParameter("id"));
        postService.deletePost(postId);
        getServletContext().getRequestDispatcher("/pages/feed.jsp").forward(req, resp);
    }
}
