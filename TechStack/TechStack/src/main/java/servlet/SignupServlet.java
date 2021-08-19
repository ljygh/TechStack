package servlet;

import bean.User;
import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(name = "SignupServlet", value = "/SignupServlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username == null || password == null){
            String error = "数据传送错误，请重试";
            error = URLEncoder.encode(error, "UTF-8");
            response.sendRedirect(request.getContextPath() + "/jsp/signup.jsp?error=" + error + "&username=" + username + "&password=" + password);
            return;
        }
        try {
            if(DAOFactory.getUserService().getUserByName(username) != null){
                String error = "用户名已存在";
                error = URLEncoder.encode(error, "UTF-8");
                username = URLEncoder.encode(username, "UTF-8");
                password = URLEncoder.encode(password, "UTF-8");
                response.sendRedirect(request.getContextPath() + "/jsp/signup.jsp?error=" + error + "&username=" + username + "&password=" + password);
                return;
            }
            User user = new User(username, password);
            DAOFactory.getUserService().insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        username = URLEncoder.encode(username, "UTF-8");
        password = URLEncoder.encode(password, "UTF-8");
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?username=" + username + "&password=" + password);
    }
}
