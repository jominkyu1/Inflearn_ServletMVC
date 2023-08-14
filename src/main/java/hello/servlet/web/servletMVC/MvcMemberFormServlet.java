package hello.servlet.web.servletMVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    // MVC - Controller (Servlet방식)
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //WEB-INF에 있는 jsp파일은 외부 웹클라이언트에서 접근불가. 컨트롤러를 통해서만 접근가능
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);

        requestDispatcher.forward(req, resp);
    }
}
