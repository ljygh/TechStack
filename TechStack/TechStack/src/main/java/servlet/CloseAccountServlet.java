package servlet;

import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(name = "CloseAccountServlet", value = "/CloseAccountServlet")
public class CloseAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String message = "";
        session.removeAttribute("userid");
        session.removeAttribute("username");
        try {
            if(DAOFactory.getUserService().delete(username))
                message = "账户注销成功";
            else
                message = "账户注销失败";
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        message = URLEncoder.encode(message, "UTF-8");
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?message=" + message);
    }
}
