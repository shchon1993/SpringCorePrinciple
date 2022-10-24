package hello.core.singleton;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulSErvuce1 = ac.getBean(StatefulService.class);
        StatefulService statefulSErvuce2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자가 10000원 주문
        int userAPrice = statefulSErvuce1.order("userA", 10000);
        //ThreadB : B사용자가 20000원 주문
        int userBPrice = statefulSErvuce2.order("userB", 20000);

        //ThreadA : 사용자 A가 주문 금액 조회
        //int price = statefulSErvuce1.getPrice();
        System.out.println("price = " + userAPrice);

        //assertThat(statefulSErvuce1.getPrice()).isEqualTo(20000);


    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }


}