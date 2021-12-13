package by.fakeinstagram.servlet;


import by.fakeinstagram.dao.PostDao;
import by.fakeinstagram.entity.Comment;
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
import java.util.List;

//TODO
@WebServlet(urlPatterns = "/createpost", name = "CreatePostServlet")
public class CreatePostServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/createPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO List<Comment> commentList = req.get
        //TODO Like like = new Like();

        User user = (User) req.getSession().getAttribute("user");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        LocalDateTime dateOfCreation = LocalDateTime.now();
        Post post = new Post(title, description, dateOfCreation);
        postService.createPost(user, post);

        getServletContext().getRequestDispatcher("/pages/feed.jsp").forward(req, resp);
    }
}
