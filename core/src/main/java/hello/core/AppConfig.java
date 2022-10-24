package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.memberr.MemberRepository;
import hello.core.memberr.MemberService;
import hello.core.memberr.MemberServiceImpl;
import hello.core.memberr.MemmoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //외부 즉,AppConfig에서 생성자를 통해서 어떤 구현 객체를 주입할지 결정한다.
    //생성자 주입, 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입한다.
    //실제 동작에 필효한 구현 객체를 생성
    //객체의 생성과 연결은 여기서 담당.
    //관심사 분리
    //공연 기획자와 동일한 역할
    //구현 클래스를 선택한다. 배역에 맞는 담당 배우를 선태한다. 애플리케이션이 어떻게 동작해야 할지 전체 구성을 책임진다.

    //IoC 제어의 역전
    //OderServiceImpl도 여기서 생성. Orderservice 인터페이스이 다른 구현 객체를 생성하고 실행할 수 있다.
    //OderServiceImpl에서는 필요한 인터페이스들이 호출 되지만 어떤 구현 객체들이 실행될지 모름.
    //외부 즉 AppConfig에서 프로그램의 제어 흐름을 관리한다.

    //의존관계 주입


    //@Bean memberService -> new MemmoryMemberRepository()
    //@bean orderService -> new MemmoryMemberRepository()


    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        //MemberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고해서 DI 의존관계 주입 또는 의존성 주입이라고 한다.
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemmoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
