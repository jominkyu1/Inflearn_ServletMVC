package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    } // ModelAndView 혹은 논리경로(String)만 반환해도 됨

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(   //어노테이션으로 쿼리파라미터를 직접 받을 수 있음
            @RequestParam("username") String username, @RequestParam("age") int age, Model model){
        Member member = new Member(username, age);
        memberRepository.save(member); //매개변수에 PK ID까지 set됨

        model.addAttribute("member", member); //ModelAndView를 사용하지않고 Model을 받아와서 사용

        return "save-result";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model){
        List<Member> allMembers = memberRepository.findAll();
        model.addAttribute("members", allMembers);

        return "members";
    }
}
