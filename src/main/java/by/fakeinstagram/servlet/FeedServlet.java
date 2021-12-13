package by.fakeinstagram.servlet;

import by.fakeinstagram.entity.Post;
import by.fakeinstagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/feed", name = "FeedServlet")
public class FeedServlet extends HttpServlet {

    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/feed.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allPosts", postService.getAllPosts());

        getServletContext().getRequestDispatcher("/pages/feed.jsp").forward(req, resp);
    }
}
