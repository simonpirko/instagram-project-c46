package by.fakeinstagram.web.filter;

import by.fakeinstagram.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
public class AuthorizationFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("logInErrorMessage", "Log in system.");
            req.getRequestDispatcher("/pages/sign-in.jsp").forward(req, res);
        }
    }
}
