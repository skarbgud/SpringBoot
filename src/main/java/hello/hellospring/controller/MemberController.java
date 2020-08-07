package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 컨트롤러가 스프링 빈으로 자동등록된 이유도 컴포넌트 스캔 때문이다.
public class MemberController {

//    @Autowired  // 필드 주입
//    private MemberService memberService;

    // setter 주입
    private MemberService memberService;
    
    @Autowired
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }

    // 의존관계 주입 (컴포넌트 스캔과 자동 의존관계 설정)
    // 생성자를 생성하여 객체가 생성될 때 Service를 Autowired를 통해서 Service 객체를 주입
//    @Autowired
//    public MemberController(MemberService memberService){
//        this.memberService = memberService;
//    }
    // 거의 생성자 주입 사용

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMembersForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
