package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public HashMap<String, Integer> prices = populatePrices();

    public Integer checkout(String skus) {
        Map<String, Integer> skuCount = new HashMap<>();
        int offerA = 0;
        int fullPriceA = 0;
        int offerB = 0;
        int fullPriceB = 0;
        int priceForC = 0;
        int priceForD = 0;

        for (char c : skus.toCharArray()) {
            
            if (!Character.isLetter(c)) {
                return -1;
            } else {
                String letter = String.valueOf(c);
                skuCount.put(letter, skuCount.getOrDefault(letter, 0) + 1);
            }
        }


        int numberOfA = skuCount.get("A") == null ? 0 : skuCount.get("A");
        if (numberOfA > 3) {
            int numberOfOffer = numberOfA / 3;
            int numberOfFullPrice = numberOfA % 3;
            offerA = numberOfOffer * 130;
            fullPriceA = numberOfFullPrice * prices.get("A");

        }

        int numberOfB = skuCount.get("B") == null ? 0 : skuCount.get("B") ;
        if (numberOfB > 2) {
            int numberOfOffer = numberOfB / 2;
            int numberOfFullPrice = numberOfB % 2;
            offerB = numberOfOffer * 45;
            fullPriceB = numberOfFullPrice * prices.get("B");

        }
        priceForC = getPriceForSku(skuCount, prices, "C");
        priceForD = getPriceForSku(skuCount, prices, "D");

        return offerA + fullPriceA + offerB + fullPriceB + priceForC + priceForD;

    }

    private int getPriceForSku(Map<String, Integer> skuCount, HashMap<String, Integer> prices, String letter){
        if (skuCount == null) return -1;
        int number = skuCount.get(letter) == null ? 0 : skuCount.get(letter);
        return number * prices.get(letter);
    }

    private static HashMap<String, Integer> populatePrices() {
        HashMap<String, Integer> pricesPopulated = new HashMap<>();
        pricesPopulated.put("A", 50);
        pricesPopulated.put("B", 50);
        pricesPopulated.put("C", 50);
        pricesPopulated.put("D", 15);
        return pricesPopulated;
    }

    public HashMap<String, Integer> getPrices() {
        return this.prices;
    }


}


