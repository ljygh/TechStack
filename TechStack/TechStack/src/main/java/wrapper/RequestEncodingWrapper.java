package wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class RequestEncodingWrapper extends HttpServletRequestWrapper {

    public RequestEncodingWrapper(HttpServletRequest request) {
        super(request);
    }

    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        try {
            if(value == null || value.equals("") || value.equals(new String(value.trim().getBytes("UTF-8"), "UTF-8")))
                return value;
            value = new String(value.trim().getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
