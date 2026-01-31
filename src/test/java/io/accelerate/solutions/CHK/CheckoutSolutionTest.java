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
    @Test
    public void checkoutTest31(){
        assertThat(checkoutSolution.checkout("HHHHH"), equalTo(45));
    }
    @Test
    public void checkoutTest32(){
        assertThat(checkoutSolution.checkout("HHHHHH"), equalTo(55));
    }
    @Test
    public void checkoutTest33(){
        assertThat(checkoutSolution.checkout("HHHHHHHHHH"), equalTo(80));
    }
    @Test
    public void checkoutTest34(){
        assertThat(checkoutSolution.checkout("HHHHHHHHHHH"), equalTo(90));
    }
    @Test
    public void checkoutTest35(){
        assertThat(checkoutSolution.checkout("H"), equalTo(10));
    }
    @Test
    public void checkoutTest36(){
        assertThat(checkoutSolution.checkout("K"), equalTo(80));
    }
    @Test
    public void checkoutTest37(){
        assertThat(checkoutSolution.checkout("KK"), equalTo(150));
    }
    @Test
    public void checkoutTest38(){
        assertThat(checkoutSolution.checkout("N"), equalTo(40));
    }
    @Test
    public void checkoutTest39(){
        assertThat(checkoutSolution.checkout("NNN"), equalTo(120));
    }
    @Test
    public void checkoutTest40(){ assertThat(checkoutSolution.checkout("NNNM"), equalTo(120));}
    @Test
    public void checkoutTest41(){
        assertThat(checkoutSolution.checkout("NNNMM"), equalTo(135));
    }
    @Test
    public void checkoutTest42(){
        assertThat(checkoutSolution.checkout("P"), equalTo(50));
    }
    @Test
    public void checkoutTest43(){ assertThat(checkoutSolution.checkout("PPPPP"), equalTo(200));}
    @Test
    public void checkoutTest44(){ assertThat(checkoutSolution.checkout("PPPPPP"), equalTo(250));}
    @Test
    public void checkoutTest45(){
        assertThat(checkoutSolution.checkout("Q"), equalTo(30));
    }
    @Test
    public void checkoutTest46(){ assertThat(checkoutSolution.checkout("QQQ"), equalTo(80));}
    @Test
    public void checkoutTest47(){ assertThat(checkoutSolution.checkout("QQQQ"), equalTo(110));}
    @Test
    public void checkoutTest48(){ assertThat(checkoutSolution.checkout("R"), equalTo(50));}
    @Test
    public void checkoutTest49(){ assertThat(checkoutSolution.checkout("RRRQ"), equalTo(150));}
    @Test
    public void checkoutTest50(){ assertThat(checkoutSolution.checkout("RRRQQ"), equalTo(180));}
    @Test
    public void checkoutTest51(){
        assertThat(checkoutSolution.checkout("UUU"), equalTo(120));
    }
    @Test
    public void checkoutTest52(){
        assertThat(checkoutSolution.checkout("U"), equalTo(40));
    }
    @Test
    public void checkoutTest53(){
        assertThat(checkoutSolution.checkout("UUUU"), equalTo(120));
    }
    @Test
    public void checkoutTest54(){
        assertThat(checkoutSolution.checkout("VV"), equalTo(90));
    }

    @Test
    public void checkoutTest55(){
        assertThat(checkoutSolution.checkout("VVV"), equalTo(130));
    }

    @Test
    public void checkoutTest56() { assertThat(checkoutSolution.checkout("VVVV"), equalTo(180));}
    @Test
    public void checkoutTest58(){
        assertThat(checkoutSolution.checkout("STXYZ"), equalTo(82));
    }
    @Test
    public void checkoutTest59(){
        assertThat(checkoutSolution.checkout("STXYZSTXYZ"), equalTo(152));
    }
}

