package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//  스프링이 자동으로 스프링 빈으로 등록한다. (내부에 @Component 애노테이션이 있어서 컴포넌트스캔의 대상이 됨)
//  스프링 MVC에서 애노테이션 기반 컨트롤러로 인식한다. (RequestMappingHandlerMapping에서 관리하는 대상이 됨)
//@Component //스프링 빈 등록
//@RequestMapping //class 레벨에 RequestMapping이 있으면 핸들러매핑이 관리

@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }


}
