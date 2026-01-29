package io.accelerate.solutions.CHK;

public class CheckSku {

    public static boolean isValid (String letter, boolean isValid) {
        if  (letter.equals("A") || letter.equals("B") || letter.equals("C") || letter.equals("D")
                || letter.equals("E") || letter.equals("F")) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }
}
