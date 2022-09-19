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

public class AppConfig {

    //외부 즉,AppConfig에서 생성자를 통해서 어떤 구현 객체를 주입할지 결정한다.
    //생성자 주입, 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입한다.
    //실제 동작에 필효한 구현 객체를 생성
    //객체의 생성과 연결은 여기서 담당.
    //관심사 분리
    //공연 기획자와 동일한 역할
    //구현 클래스를 선택한다. 배역에 맞는 담당 배우를 선태한다. 애플리케이션이 어떻게 동작해야 할지 전체 구성을 책임진다.


    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
        //MemberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고해서 DI 의존관계 주입 또는 의존성 주입이라고 한다.
    }

    private MemberRepository memberRepository(){
        return new MemmoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}