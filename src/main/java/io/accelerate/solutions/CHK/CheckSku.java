package io.accelerate.solutions.CHK;

import java.util.HashSet;
import java.util.Set;

public class CheckSku {

    public static Set<String> VALID_SKU = populateSkus();

    private static Set<String> populateSkus() {
        Set<String> validSkus = new HashSet<>();
        validSkus.add("A");
        validSkus.add("B");
        validSkus.add("C");
        validSkus.add("D");
        validSkus.add("E");
        validSkus.add("F");
        validSkus.add("G");
        validSkus.add("H");
        validSkus.add("I");
        validSkus.add("J");
        validSkus.add("K");
        validSkus.add("L");
        validSkus.add("M");
        validSkus.add("N");
        validSkus.add("O");
        validSkus.add("P");
        validSkus.add("Q");
        validSkus.add("R");
        validSkus.add("S");
        validSkus.add("T");
        validSkus.add("U");
        validSkus.add("V");
        validSkus.add("W");
        validSkus.add("X");
        validSkus.add("Y");
        validSkus.add("Z");
        return validSkus;
    }

    public static boolean isValid(String skus) {
        boolean isValid = true;
        for (int i = 0; i < skus.length(); i++) {
            String letter = skus.substring(i, i+1);
            if (!VALID_SKU.contains(letter)) {
                isValid = false;
                return isValid;
            }
        } return isValid;
    }
}
