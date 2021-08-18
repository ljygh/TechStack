package servlet;

import bean.User;
import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "servlet.LoginValidateServlet", value = "/servlet.LoginValidateServlet")
public class LoginValidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String error = "";
        boolean isValidate = true;
        try {
            User user = DAOFactory.getUserService().getUser(username);
            if(user == null){
                isValidate = false;
                error += "用户名不存在";
            }
            else {
                if(!user.getPassword().equals(password)){
                    isValidate = false;
                    error += "密码错误";
                }
            }
            if(isValidate)
                response.sendRedirect(request.getContextPath() + "/jsp/personalMain.jsp?username=" + username);
            else
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?error=" + error);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
