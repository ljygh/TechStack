package servlet;

import bean.User;
import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(name = "/LoginValidateServlet", value = "/LoginValidateServlet")
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
                username = "";
            }
            else {
                if(!user.getPassword().equals(password)){
                    isValidate = false;
                    error += "密码错误";
                    password = "";
                }
            }
            if(isValidate)
                response.sendRedirect(request.getContextPath() + "/jsp/personalMain.jsp?username=" + username);
            else{
                //使用sendRedirect 有中文参数的情况下要设置编码，不然过滤器也不能转码
                error = URLEncoder.encode(error, "UTF-8");
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?username=" + username + "&password=" + password + "&error=" + error);
                /*
                使用dispatcher 不能跳转，不知为何
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
                dispatcher.forward(request, response);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
