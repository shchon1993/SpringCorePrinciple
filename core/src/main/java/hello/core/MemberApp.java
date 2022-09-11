package hello.core;

import hello.core.memberr.Grade;
import hello.core.memberr.Member;
import hello.core.memberr.MemberService;
import hello.core.memberr.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) { //psvm
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member finmember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMemebr = " + finmember.getName());
    }
}
