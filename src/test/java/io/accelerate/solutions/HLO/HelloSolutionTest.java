package io.accelerate.solutions.HLO;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class HelloSolutionTest {
    private HelloSolution hloSolution;

    @Test
    public void helloTest(){
        assertThat(hloSolution.hello("World"), equals("Hello World!"));
    }
}

