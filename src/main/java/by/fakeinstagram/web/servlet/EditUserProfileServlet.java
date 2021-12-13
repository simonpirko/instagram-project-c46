package by.fakeinstagram.web.servlet;

import by.fakeinstagram.entity.User;
import by.fakeinstagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/editUserProfile", name = "EditUserProfileServlet")
public class EditUserProfileServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/editUserProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Integer.parseInt(req.getParameter("id"));

        User user = userService.findUserById(id).get();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setBirthDate(LocalDate.parse(req.getParameter("birthDate")));
        user.setCountry(req.getParameter("country"));
        user.setBiography(req.getParameter("biography"));
        req.getSession().setAttribute("user", user);

        userService.updateUserProfile(user);
        resp.sendRedirect("/userProfile");
    }
}
