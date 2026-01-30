package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

import static io.accelerate.solutions.CHK.Prices.getPriceForSku;
import static io.accelerate.solutions.CHK.Prices.populatePrices;

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
        int offerPriceF = 0;
        int priceForF = 0;

        for (int i = 0; i < skus.length(); i++) {
            String letter = skus.substring(i, i+1);
            if (CheckSku.isValid(letter, illegalInput)) {
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

        if (Offers.isValidForOfferBuyXGetOneFree(skuCount,  "F", 2)) {
            Offers.updateSkuCountMapForOfferBuyXGetOneFree(skuCount, "F", 2);
        }

        if (Offers.isValidForOfferBuyXGetOneFree(skuCount,  "U", 3)) {
            Offers.updateSkuCountMapForOfferBuyXGetOneFree(skuCount, "U", 3);
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
        offerPriceF = getPriceForSku(skuCount, prices, "F");

        if (illegalInput == false) {
            return offerA + fullPriceA + offerB + fullPriceB + priceForC + priceForD +
                    priceForE + fullPriceA2 + offerA2 + offerPriceF;
        } else return -1;

    }
}



