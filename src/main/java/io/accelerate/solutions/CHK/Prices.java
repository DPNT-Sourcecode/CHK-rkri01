package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class Prices {

    public static  HashMap<String, Integer> PRICELIST = populatePrices();

    private static HashMap<String, Integer> populatePrices() {
        HashMap<String, Integer> pricesPopulated = new HashMap<>();
        pricesPopulated.put("A", 50);
        pricesPopulated.put("B", 30);
        pricesPopulated.put("C", 20);
        pricesPopulated.put("D", 15);
        pricesPopulated.put("E", 40);
        pricesPopulated.put("F", 10);
        return pricesPopulated;
    }

    public static int getPriceForSku(Map<String, Integer> skuCount, HashMap<String, Integer> prices, String letter){
        if (skuCount == null) return -1;
        int number = skuCount.get(letter) == null ? 0 : skuCount.get(letter);
        return number * prices.get(letter);
    }
}
