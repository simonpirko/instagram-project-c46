package by.fakeinstagram.servlet;

import by.fakeinstagram.entity.Like;
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

@WebServlet(urlPatterns = "/editpost", name = "EditPostServlet")
public class EditPostServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/editpost.jsp").forward(req, resp);//или не делать новую страницу а просто добавить кнопку
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        LocalDateTime dateOfCreation = LocalDateTime.now();
        Post post = new Post(title, description, dateOfCreation);
        postService.updatePost(post);

        getServletContext().getRequestDispatcher("/pages/editPost.jsp").forward(req, resp);
    }
}
