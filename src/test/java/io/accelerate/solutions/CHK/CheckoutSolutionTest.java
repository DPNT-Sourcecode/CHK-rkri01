package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkoutSolution;

    @BeforeEach
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
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
    @Test
    public void checkoutTest13(){
        assertThat(checkoutSolution.checkout("AAAAAAAAA"), equalTo(380));
    }
    @Test
    public void checkoutTest14(){
        assertThat(checkoutSolution.checkout("FFF"), equalTo(20));
    }
    @Test
    public void checkoutTest15(){
        assertThat(checkoutSolution.checkout("F"), equalTo(10));
    }
    @Test
    public void checkoutTest16(){
        assertThat(checkoutSolution.checkout("FFFF"), equalTo(30));
    }
    @Test
    public void checkoutTest17(){
        assertThat(checkoutSolution.checkout("FFFFAAAAABB"), equalTo(275));
    }
    @Test
    public void checkoutTest18(){
        assertThat(checkoutSolution.checkout("FFFFF"), equalTo(40));
    }
    @Test
    public void checkoutTest19(){ assertThat(checkoutSolution.checkout("G"), equalTo(20));}
    @Test
    public void checkoutTest20(){
        assertThat(checkoutSolution.checkout("I"), equalTo(35));
    }
    @Test
    public void checkoutTest21(){
        assertThat(checkoutSolution.checkout("J"), equalTo(60));
    }
    @Test
    public void checkoutTest22(){
        assertThat(checkoutSolution.checkout("L"), equalTo(90));
    }
    @Test
    public void checkoutTest23(){
        assertThat(checkoutSolution.checkout("M"), equalTo(15));
    }
    @Test
    public void checkoutTest24(){
        assertThat(checkoutSolution.checkout("O"), equalTo(10));
    }
    @Test
    public void checkoutTest25(){
        assertThat(checkoutSolution.checkout("S"), equalTo(30));
    }
    @Test
    public void checkoutTest26(){
        assertThat(checkoutSolution.checkout("T"), equalTo(20));
    }
    @Test
    public void checkoutTest27(){
        assertThat(checkoutSolution.checkout("W"), equalTo(20));
    }
    @Test
    public void checkoutTest28(){
        assertThat(checkoutSolution.checkout("X"), equalTo(90));
    }
    @Test
    public void checkoutTest29(){
        assertThat(checkoutSolution.checkout("Y"), equalTo(10));
    }
    @Test
    public void checkoutTest30(){ assertThat(checkoutSolution.checkout("Z"), equalTo(50));}











}


