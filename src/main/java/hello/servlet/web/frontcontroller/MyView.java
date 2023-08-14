package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    private final String viewPath;
    private String viewName;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public MyView(String viewPath, String viewName) {
        this.viewPath = viewPath;
        this.viewName = viewName;
    }

    public String getViewName(){
        return viewName;
    }

    public void setViewName(String viewName){
        this.viewName = viewName;
    }

    public void render(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);

        System.out.println("MyView render메소드 실행");
    }

    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        modelToRequestAttribute(model, req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        requestDispatcher.forward(req, resp);

        System.out.println("MyView model이 포함된 render메소드 실행");
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest req) {
        model.forEach(
                //(key, value) -> req.setAttribute(key, value)
                req::setAttribute
        );
    }
}
