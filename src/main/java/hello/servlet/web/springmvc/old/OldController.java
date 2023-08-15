package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Bean의 이름을 URI로 지정하면 스프링내에서 HandlerMapping을통해 이 컨트롤러를 찾아줌
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    //이 컨트롤러를 실행할 수 있는 핸들러 어댑터가 필요하지만, 스프링에 구현이 되어있음
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
