package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    private HashMap<String, Integer> prices ;

    public Integer checkout(String skus) {
        Map<String, Integer> skuCount = new HashMap<>();
        for (char c : skus.toCharArray()) {
            if (!Character.isLetter(c)) {
                return -1;
            } else {
                String letter = String.valueOf(c);
                skuCount.put(letter, skuCount.getOrDefault(letter, 0) + 1);
            }
        }
    }

    private HashMap<String, Integer> populatePrices(HashMap<String, Integer> prices) {
        HashMap<String, Integer> pricesPopulated = new HashMap<>();
        pricesPopulated.put("A", 50);
        pricesPopulated.put("B", 50);
        pricesPopulated.put("C", 50);
        pricesPopulated.put("D", 15);

    }
}
