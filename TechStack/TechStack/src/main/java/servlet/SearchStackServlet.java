package servlet;

import bean.Stack;
import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchStackServlet", value = "/SearchStackServlet")
public class SearchStackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = (Integer) request.getSession().getAttribute("userid");
        String sname = request.getParameter("stackname");
        try {
            List<Stack> stackList = DAOFactory.getUser_StackService().SearchStackByName(uid, sname);
            request.setAttribute("stackList", stackList);
            request.getRequestDispatcher("jsp/personal.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
