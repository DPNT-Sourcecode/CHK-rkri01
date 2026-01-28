package io.accelerate.solutions.SUM;


@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        if (x <= 100 && y <= 100) {
            return x + y;
        } else throw new IllegalArgumentException();
    }

}

