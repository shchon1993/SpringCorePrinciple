package hello.core.member;

import hello.core.memberr.Grade;
import hello.core.memberr.Member;
import hello.core.memberr.MemberService;
import hello.core.memberr.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA", Grade.VIP); //Member객체에 해당 데이터 넣고

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L); //id = 1L인 애가 있는지 찾은 후 finmember객체에 넣고

        //then
        Assertions.assertThat(member).isEqualTo(findMember); //member객체와 findMember객체 값이 같은 지 확인


    }

}
