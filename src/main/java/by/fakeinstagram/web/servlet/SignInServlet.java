package by.fakeinstagram.web.servlet;

import by.fakeinstagram.entity.User;
import by.fakeinstagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/sign-in", name = "SignInServlet")
public class SignInServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/sign-in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        if (userService.checkUser(email, password)) {
            HttpSession session = req.getSession();
            User user = userService.findUserByEmailAndPassword(email, password).get();
            session.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/pages/userProfile.jsp").forward(req, resp);
        } else {
            req.setAttribute("signInErrorMessage", "Email or password are incorrect.");
            getServletContext().getRequestDispatcher("/pages/sign-in.jsp").forward(req, resp);
        }
    }
}
