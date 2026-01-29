package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public HashMap<String, Integer> prices = populatePrices();

    public Integer checkout(String skus) {
        boolean illegalInput = false;
        Map<String, Integer> skuCount = new HashMap<>();
        int offerA = 0;
        int fullPriceA = 0;
        int offerB = 0;
        int fullPriceB = 0;
        int priceForC = 0;
        int priceForD = 0;
        int priceForE = 0;
        int offerA2 = 0;
        int fullPriceA2 = 0;

        for (int i = 0; i < skus.length(); i++) {
            String letter = skus.substring(i, i+1);
            if (letter.equals("A") || letter.equals("B") || letter.equals("C") || letter.equals("D") || letter.equals("E")) {
                skuCount.put(letter, skuCount.getOrDefault(letter, 0) + 1);
            } else {
                illegalInput = true;
            }
        }

        if ((skuCount.get("E") == null ? 0 : skuCount.get("E")) >=2
                && (skuCount.get("B") == null ? 0 : skuCount.get("B")) > 0) {
            int freeB = skuCount.get("E") / 2;
            int currentNumberOfBInTrolly = skuCount.get("B");
            if (currentNumberOfBInTrolly >= freeB) {
                skuCount.put("B", currentNumberOfBInTrolly - freeB);
            }
        }

        int numberOfA = skuCount.get("A") == null ? 0 : skuCount.get("A");
        if (numberOfA >= 5) {
            int numberOfOffer = numberOfA / 5;
            int numberOfFullPrice = numberOfA % 5;
            offerA = numberOfOffer * 200;
            if (numberOfFullPrice >= 3) {
                int numberOfOffer2 = numberOfFullPrice / 3;
                int numberOfFullPrice2 = numberOfFullPrice % 3;
                offerA2 = numberOfOffer2 * 130;
                fullPriceA2 = numberOfFullPrice2 * prices.get("A");
//                fullPriceA = numberOfFullPrice * prices.get("A");
            } else fullPriceA = numberOfFullPrice * prices.get("A");
        } else if (numberOfA >= 3) {
            int numberOfOffer = numberOfA / 3;
            int numberOfFullPrice = numberOfA % 3;
            offerA = numberOfOffer * 130;
            fullPriceA = numberOfFullPrice * prices.get("A");
        }  else {
            fullPriceA = getPriceForSku(skuCount, prices, "A");
        }

        int numberOfB = skuCount.get("B") == null ? 0 : skuCount.get("B") ;
        if (numberOfB >= 2) {
            int numberOfOffer = numberOfB / 2;
            int numberOfFullPrice = numberOfB % 2;
            offerB = numberOfOffer * 45;
            fullPriceB = numberOfFullPrice * prices.get("B");

        } else {
            fullPriceB = getPriceForSku(skuCount, prices, "B");
        }

        priceForC = getPriceForSku(skuCount, prices, "C");
        priceForD = getPriceForSku(skuCount, prices, "D");
        priceForE = getPriceForSku(skuCount, prices, "E");

        if (illegalInput == false) {
            return offerA + fullPriceA + offerB + fullPriceB + priceForC + priceForD + priceForE + fullPriceA2 + offerA2;
        } else return -1;

    }

    private int getPriceForSku(Map<String, Integer> skuCount, HashMap<String, Integer> prices, String letter){
        if (skuCount == null) return -1;
        int number = skuCount.get(letter) == null ? 0 : skuCount.get(letter);
        return number * prices.get(letter);
    }

    private static HashMap<String, Integer> populatePrices() {
        HashMap<String, Integer> pricesPopulated = new HashMap<>();
        pricesPopulated.put("A", 50);
        pricesPopulated.put("B", 30);
        pricesPopulated.put("C", 20);
        pricesPopulated.put("D", 15);
        pricesPopulated.put("E", 40);
        return pricesPopulated;
    }

    public HashMap<String, Integer> getPrices() {
        return this.prices;
    }


}



