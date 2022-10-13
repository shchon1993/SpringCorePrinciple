package hello.core;

import hello.core.memberr.Grade;
import hello.core.memberr.Member;
import hello.core.memberr.MemberService;
import hello.core.memberr.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) { //psvm
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl(memberRepository);

        //모든 객체 관리 @Bean, Appconfig에 있는 설정정보를 가지고  객체 생성한 내용을 다 Spring컨테이너에 넣어준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member finmember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMemebr = " + finmember.getName());
    }
}
