package io.accelerate.solutions.HLO;

import io.accelerate.runner.SolutionNotImplementedException;
import org.junit.platform.commons.util.StringUtils;

public class HelloSolution {
    public String hello(String friendName) {
        if (StringUtils.isNotBlank(friendName)){
            return "Hello " + friendName + "!";
        }
        else throw new IllegalArgumentException();
    }
}
