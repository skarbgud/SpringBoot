package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 컨트롤러가 스프링 빈으로 자동등록된 이유도 컴포넌트 스캔 때문이다.
public class MemberController {

    private final MemberService memberService;

    // 의존관계 주입 (컴포넌트 스캔과 자동 의존관계 설정)
    // 생성자를 생성하여 객체가 생성될 때 Service를 Autowired를 통해서 Service 객체를 주입
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
