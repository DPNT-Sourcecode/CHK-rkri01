package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class Prices {

    public static  HashMap<String, Integer> PRICELIST = populatePrices();

    public static HashMap<String, Integer> populatePrices() {
        HashMap<String, Integer> pricesPopulated = new HashMap<>();
        pricesPopulated.put("A", 50);
        pricesPopulated.put("B", 30);
        pricesPopulated.put("C", 20);
        pricesPopulated.put("D", 15);
        pricesPopulated.put("E", 40);
        pricesPopulated.put("F", 10);
        pricesPopulated.put("G", 20);
        pricesPopulated.put("H", 10);
        pricesPopulated.put("I", 35);
        pricesPopulated.put("J", 60);
        pricesPopulated.put("K", 80);
        pricesPopulated.put("L", 90);
        pricesPopulated.put("M", 15);
        pricesPopulated.put("N", 40);
        pricesPopulated.put("O", 10);
        pricesPopulated.put("P", 50);
        pricesPopulated.put("Q", 30);
        pricesPopulated.put("R", 50);
        pricesPopulated.put("S", 30);
        pricesPopulated.put("T", 20);
        pricesPopulated.put("U", 40);
        pricesPopulated.put("V", 50);
        pricesPopulated.put("W", 20);
        pricesPopulated.put("X", 90);
        pricesPopulated.put("Y", 10);
        pricesPopulated.put("Z", 50);
        return pricesPopulated;
    }

    public static int getPriceForSku(Map<String, Integer> skuCount, HashMap<String, Integer> prices, String letter){
        if (skuCount == null) return -1;
        int number = skuCount.get(letter) == null ? 0 : skuCount.get(letter);
        return number * prices.get(letter);
    }
}


