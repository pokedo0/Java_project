package servlet;

import Bean.User;
import Dao.UserDao;
import Dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doRegist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = new String(request.getParameter("username"));
        String password = new String(request.getParameter("password"));
        String gender = new String(request.getParameter("sex"));
        String temp = request.getParameter("pic");
        String pic = (temp == null) ? "0" : temp;
        System.out.println(userName);
        System.out.println(password);
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setGender(Integer.parseInt(gender));
        user.setPassword(password);
        user.setHead(pic + ".gif");
        user.setUserName(userName);
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/register.jsp");
        }
        response.sendRedirect("/login.jsp");

//        System.out.println(user);
//        if (user != null) {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("/index.jsp");
//        } else {
//            response.sendRedirect("/login.jsp");
//        }
    }
}
