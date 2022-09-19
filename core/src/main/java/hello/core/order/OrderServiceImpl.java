package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.memberr.Member;
import hello.core.memberr.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //회원
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //할인정책
    //DIP 위반, 클라이언트인 OrderServiceImpl는  DiscountPolicy 추상,인터페이스만 의조한하는게 아니라 FixDiscountPolicy 구체,구현 클래스에도 의존하고 있다.
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인정책
    //OCP 위반 -> 왜냐하면 FixDiscountPolicy를 RateDiscountPolicy로 변경하는 순간 OrderServiceImpl 소스를 변경함.

    private final DiscountPolicy discountPolicy;

    //final로 선언하면 객체를 그대로 생성하여 할당하던, 생성자를 통하여 할당해야함.
    //철저하게 DIP를 지키고 있음. 인터페이스만 의존, 구체적인 클래스에 대해서 전혀 모름.
    //discountPolicy 인터페이스에만 의존
    //OCP 만족 / 확장에는 열려 있고 변경에는 닫혀있다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //추상,인터페이스에만 의존하도록 설계와 코드 변경

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
