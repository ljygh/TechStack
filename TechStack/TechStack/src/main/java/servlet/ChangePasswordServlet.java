package servlet;

import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(name = "ChangePasswordServlet", value = "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPswd = request.getParameter("pswd");
        String username = (String) request.getSession().getAttribute("username");
        String message = "";
        try {
            String password = DAOFactory.getUserService().getUserByName(username).getPassword();
            if(password.equals(newPswd))
                message = "新密码与原密码相同";
            else {
                if(DAOFactory.getUserService().updatePswd(username, newPswd) == false)
                    message = "密码修改失败";
                else
                    message = "密码修改成功";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        message = URLEncoder.encode(message, "UTF-8");
        response.sendRedirect(request.getContextPath() + "/jsp/personal.jsp?message=" + message);
    }
}
