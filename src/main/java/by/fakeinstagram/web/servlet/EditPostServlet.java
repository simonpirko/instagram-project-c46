package by.fakeinstagram.web.servlet;
import by.fakeinstagram.entity.Post;

import by.fakeinstagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/editpost", name = "EditPostServlet")
public class EditPostServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("post", postService.getPostById(Long.parseLong(req.getParameter("id"))).get());
        getServletContext().getRequestDispatcher("/pages/editPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Post post = postService.getPostById(id).get();
        post.setTitle(req.getParameter("title"));
        post.setDescription(req.getParameter("description"));
        postService.updatePost(post);

        resp.sendRedirect("/feed");
    }
}
