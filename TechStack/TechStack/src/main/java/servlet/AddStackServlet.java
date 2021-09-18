package servlet;

import daoFactory.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(name = "AddStackServlet", value = "/AddStackServlet")
public class AddStackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        String sDescription = request.getParameter("sDescription");
        int uid = (Integer) request.getSession().getAttribute("userid");
        try {
            boolean isExist = DAOFactory.getUser_StackService().isContainStack(uid, sname);
            if(isExist){
                String message = "新建栈失败，栈名已存在";
                message = URLEncoder.encode(message, "utf-8");
                response.sendRedirect(request.getContextPath() + "/ShowAllStackServlet?message=" + message);
                return;
            }
            else {
                int sid = DAOFactory.getStackService().insert(sname, sDescription);
                if(sid < 0){
                    String message = "数据库错误，插入失败";
                    message = URLEncoder.encode(message, "utf-8");
                    response.sendRedirect(request.getContextPath() + "/jsp/personal.jsp?message=" + message);
                    return;
                }
                DAOFactory.getUser_StackService().insert(uid, sid);
                response.sendRedirect(request.getContextPath() + "/jsp/myStack.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
