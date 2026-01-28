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
}


