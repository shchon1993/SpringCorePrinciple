package hello.core.discount;

import hello.core.memberr.Grade;
import hello.core.memberr.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //enum은 == 연산자를 사용하는게 맞다.
            return discountFixAmount;
        }
        else{
            return 0;
        }
            


    }
}
