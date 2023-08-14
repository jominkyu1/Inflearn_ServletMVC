package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        Enumeration<String> parameterNames = req.getParameterNames();

        while(parameterNames.hasMoreElements()){
            String element = parameterNames.nextElement();
            String elementValue = req.getParameter(element);

            System.out.println(element + " -> " + elementValue);

            //응답
            //Header
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("utf-8");

            //Body
            resp.getWriter().write(element + " -> " + elementValue);
        }
    }
}
