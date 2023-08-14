package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV4", urlPatterns="/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private final Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4(){
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontController V4 실행");
        String requestURI = req.getRequestURI();
        ControllerV4 controllerV4 = controllerMap.get(requestURI);

        if(controllerV4==null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Map<String, String> paraMap = createParaMap(req);
        Map<String, Object> model = new HashMap<>();

        String viewName = controllerV4.process(paraMap, model);

        MyView myView = viewResolver(viewName);
        myView.render(model, req, resp);
    }

    public MyView viewResolver(String viewName){
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
    public Map<String, String> createParaMap(HttpServletRequest req){
        Map<String, String> paraMap = new HashMap<>();
        Enumeration<String> parameterNames = req.getParameterNames();

        while(parameterNames.hasMoreElements()){
            String paraName = parameterNames.nextElement();
            paraMap.put(paraName, req.getParameter(paraName));
        }
        return paraMap;
    }
}
