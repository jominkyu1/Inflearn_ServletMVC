package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 *  1. 파라미터 전송 기능
 *  http://localhost:8080/request-param?username=hong&age=50
 * */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameterNames().asIterator().forEachRemaining(
                n -> System.out.println( n + " -> " + req.getParameter(n))
        );

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        if(Objects.equals(id, "") || Objects.equals(name, "")){
            resp.sendError(400, "NULL");
        }
        resp.getWriter().write(id + " and " + name);
    }
}