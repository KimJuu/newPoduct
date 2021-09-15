package com.example.newPoduct.Service;

import com.example.newPoduct.domain.Member;
import com.example.newPoduct.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    void 회원가입(){
        //given
        Member member = new Member();
        member.setEmail("asd@naver.com");
        member.setPassword("1234");
        member.setAddress("서울특별시 노원구 공릉동");

        //when
        Long saveId = memberService.join(member);

        //then
        Member result = memberService.findOne(saveId).get();
        assertThat(member.getEmail()).isEqualTo(result.getEmail());

    }
}