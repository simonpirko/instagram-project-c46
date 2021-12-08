package by.fakeinstagram.servlet;

import by.fakeinstagram.entity.User;
import by.fakeinstagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userForRegistration = new User();
        userForRegistration.setUserName(req.getParameter("userName"));
        userForRegistration.setEmail(req.getParameter("email"));
        userForRegistration.setPassword(req.getParameter("password"));
        userForRegistration.setFirstName(req.getParameter("firstName"));
        userForRegistration.setLastName(req.getParameter("lastName"));
        if (req.getParameter("birthDate") != null) {
            userForRegistration.setBirthDate(LocalDate.parse(req.getParameter("birthDate")));
        } else {
            userForRegistration.setBirthDate(null);
        }
        userForRegistration.setCountry(req.getParameter("country"));
        userForRegistration.setBiography(req.getParameter("biography"));

        Optional<User> optUser = userService.createUser(userForRegistration);
        req.getSession().setAttribute("optUser", optUser);
        req.getRequestDispatcher("sign-in.jsp").forward(req, resp);
    }
}
