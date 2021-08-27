package servlet;

import bean.Stack;
import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowAllStackServlet", value = "/ShowAllStackServlet")
public class ShowAllStackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int uid = (Integer) session.getAttribute("udi");
        try {
            List<Stack> stackList = DAOFactory.getUser_StackService().getAllStackOfUser(uid);
            request.setAttribute("stackList", stackList);
            request.getRequestDispatcher(request.getContextPath() + "/jsp/personal.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
