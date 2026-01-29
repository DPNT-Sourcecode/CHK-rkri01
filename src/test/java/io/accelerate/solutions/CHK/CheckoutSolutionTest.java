package io.accelerate.solutions.CHK;

import io.accelerate.solutions.HLO.HelloSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkoutSolution;

    @BeforeEach
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
        checkoutSolution.getPrices();
    }

    @Test
    public void checkoutTest(){
        assertThat(checkoutSolution.checkout("AAA"), equalTo(130));
    }

    @Test
    public void checkoutTest2(){
        assertThat(checkoutSolution.checkout("AAAB"), equalTo(160));
    }

    @Test
    public void checkoutTest3(){
        assertThat(checkoutSolution.checkout("AAABC"), equalTo(180));
    }

    @Test
    public void checkoutTest4(){
        assertThat(checkoutSolution.checkout("AAABCD"), equalTo(195));
    }

    @Test
    public void checkoutTest5(){
        assertThat(checkoutSolution.checkout("AAA2BCD"), equalTo(-1));
    }
    @Test
    public void checkoutTest6(){
        assertThat(checkoutSolution.checkout("A"), equalTo(50));
    }
    @Test
    public void checkoutTest7(){
        assertThat(checkoutSolution.checkout("E"), equalTo(40));
    }
    @Test
    public void checkoutTest8(){
        assertThat(checkoutSolution.checkout("EEB"), equalTo(80));
    }
    @Test
    public void checkoutTest9(){
        assertThat(checkoutSolution.checkout("EEBB"), equalTo(110));
    }
    @Test
    public void checkoutTest10(){
        assertThat(checkoutSolution.checkout("AAAAA"), equalTo(200));
    }
    @Test
    public void checkoutTest11(){
        assertThat(checkoutSolution.checkout("AAAAAA"), equalTo(250));
    }
    @Test
    public void checkoutTest12(){
        assertThat(checkoutSolution.checkout("AAAAAAAA"), equalTo(330));
    }











}

