package com.example.newPoduct.Service;

import com.example.newPoduct.domain.Member;
import com.example.newPoduct.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */

    public Long join(Member member){
        //validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

/*
    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
*/

    /**
     * ID 조회
     */

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
