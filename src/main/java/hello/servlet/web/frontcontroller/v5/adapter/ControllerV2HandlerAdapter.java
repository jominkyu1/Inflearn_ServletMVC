package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV2HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV2);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV2 controller = (ControllerV2) handler;
        Map<String, Object> model = new HashMap<>();

        MyView myView = controller.process(request, response);

        ModelView modelView = new ModelView(myView.getViewName());

        //V2는 컨트롤러내에서 서블릿에 직접적으로 setAttribute로 중간모델을 설정했기때문에 getAttribute로 값을 빼내와 
        //V5 컨트롤러가 요구하는 모델에 복사해서 옮겨담음

        request.getAttributeNames().asIterator().forEachRemaining(
                s -> model.put(s, request.getAttribute(s))
        );

        modelView.setModel(model);

        return modelView;

    }
}
