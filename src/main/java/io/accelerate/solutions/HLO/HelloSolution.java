package io.accelerate.solutions.HLO;

public class HelloSolution {
    public String hello(String friendName) {
        if (friendName != null) {
            if (!friendName.isEmpty()) {
                return "Hello " + friendName + "!";
            }
        }
        return "Please enter a name.";
    }
}

