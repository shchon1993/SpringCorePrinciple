package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.memberr.MemberService;
import hello.core.memberr.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로만 조회")
    void findBeanByName(){
        MemberService memberSerivce = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService: " + memberSerivce);
        System.out.println("memberService.getClass() = : " + memberSerivce.getClass());
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberSerivce = ac.getBean(MemberService.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    //역할이 아닌 구현에 의존
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberSerivce = ac.getBean("memberService", MemberServiceImpl.class);
        System.out.println("memberService: " + memberSerivce);
        System.out.println("memberService.getClass() = : " + MemberServiceImpl.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findNoNameBean(){
        //MemberService noNameSerivce = ac.getBean("NoNameSerivce", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("NoNameSerivce", MemberService.class));
    }

}
