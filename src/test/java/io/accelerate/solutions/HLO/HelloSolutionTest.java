package io.accelerate.solutions.HLO;

import io.accelerate.solutions.SUM.SumSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class HelloSolutionTest {
    private HelloSolution hloSolution;

    @BeforeEach
    public void setUp() {
        hloSolution = new HelloSolution();
    }

    @Test
    public void helloTest(){
        assertThat(hloSolution.hello("World"), equals("Hello World!"));
    }
}


