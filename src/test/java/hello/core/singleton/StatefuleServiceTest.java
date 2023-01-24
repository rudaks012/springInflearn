package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefuleServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefuleService statefuleService = ac.getBean(StatefuleService.class);
        StatefuleService statefuleService2 = ac.getBean(StatefuleService.class);

        //ThreadA: A사용자 10000원 주문
        statefuleService.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        statefuleService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        int price = statefuleService.getPrice();
        System.out.println("price = " + price);

        assertThat(statefuleService.getPrice()).isEqualTo(20000);
    }

    static class  TestConfig {

        @Bean
        public StatefuleService statefulService() {
            return new StatefuleService();
        }
    }

}