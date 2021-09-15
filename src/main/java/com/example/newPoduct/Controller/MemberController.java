package com.example.newPoduct.Controller;

import com.example.newPoduct.Service.MemberService;
import com.example.newPoduct.domain.Member;
import com.example.newPoduct.model.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form){
        Member member = new Member();

        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setAddress(form.getAddress());

        memberService.join(member);

        return "redirect:/";
    }

}
