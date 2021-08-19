package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = "*.jsp")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String excludePage1 = "http://localhost/TechStack_war_exploded/jsp/login.jsp";
        String excludePage2 = "http://localhost/TechStack_war_exploded/jsp/signup.jsp";
        if(excludePage1.equals(httpRequest.getRequestURL().toString()) || excludePage2.equals(httpRequest.getRequestURL().toString())){
            chain.doFilter(request, response);
            return;
        }
        HttpSession session = httpRequest.getSession();
        if(session.getAttribute("userid") == null){
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/login.jsp");
            chain.doFilter(request, response);
        }
        else
            chain.doFilter(request, response);
    }
}
