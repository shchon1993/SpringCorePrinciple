package hello.core.discount;

import hello.core.memberr.Grade;
import hello.core.memberr.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    //ctrl + shift + t = 테스트파일 생성
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        else{
            return 0;
        }

    }
}
