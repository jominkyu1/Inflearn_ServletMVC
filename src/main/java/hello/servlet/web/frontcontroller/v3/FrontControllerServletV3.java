package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private final Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3(){
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontController V3 실행");
        String requestURI = req.getRequestURI();
        ControllerV3 controllerV3 = controllerMap.get(requestURI);

        if(controllerV3==null){
            resp.setStatus(404);
            return;
        }
        //paraMap 메소드 추출
        Map<String, String> paraMap = createParaMap(req);

        ModelView mv = controllerV3.process(paraMap);
        
        //뷰네임(논리경로)만 받아옴. 이후에 모든경로(물리경로)는 뷰 리졸버를 통해 경로생성
        String viewName = mv.getViewName();
        MyView myView = viewResolver(viewName);

        myView.render(mv.getModel(), req, resp);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParaMap(HttpServletRequest req) {
        Map<String, String> paraMap = new HashMap<>();
        Enumeration<String> parameterNames = req.getParameterNames();

        while(parameterNames.hasMoreElements()){
            String paraName = parameterNames.nextElement();
            paraMap.put(paraName, req.getParameter(paraName));
        }
        return paraMap;
    }
}
