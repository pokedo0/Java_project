package servlet;

import Bean.User;
import Dao.UserDao;
import Dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = new String(request.getParameter("userName"));
        String password = new String(request.getParameter("password"));
        System.out.println(userName);
        System.out.println(password);
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(userName, password);
        System.out.println(user);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/index.jsp");
        } else {
            response.sendRedirect("/login.jsp");
        }
    }
}
