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
        int fullPriceG = 0;
        int fullPriceI = 0;
        int fullPriceJ = 0;
        int fullPriceL = 0;
        int fullPriceN = 0;
        int fullPriceM = 0;
        int fullPriceO = 0;
        int fullPriceR = 0;
        int fullPriceS = 0;
        int fullPriceT = 0;
        int fullPriceU = 0;
        int fullPriceW = 0;
        int fullPriceX = 0;
        int fullPriceY = 0;
        int fullPriceZ = 0;

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
        fullPriceG = getPriceForSku(skuCount, prices, "G");
        fullPriceI = getPriceForSku(skuCount, prices, "I");
        fullPriceJ = getPriceForSku(skuCount, prices, "J");
        fullPriceL = getPriceForSku(skuCount, prices, "L");
        fullPriceM = getPriceForSku(skuCount, prices, "M");
        fullPriceN = getPriceForSku(skuCount, prices, "N");
        fullPriceO = getPriceForSku(skuCount, prices, "O");
        fullPriceR = getPriceForSku(skuCount, prices, "R");
        fullPriceS = getPriceForSku(skuCount, prices, "S");
        fullPriceT = getPriceForSku(skuCount, prices, "T");
        fullPriceU = getPriceForSku(skuCount, prices, "U");
        fullPriceW = getPriceForSku(skuCount, prices, "W");
        fullPriceX = getPriceForSku(skuCount, prices, "X");
        fullPriceY = getPriceForSku(skuCount, prices, "Y");
        fullPriceZ = getPriceForSku(skuCount, prices, "Z");

        if (illegalInput == false) {
            return offerA + fullPriceA + offerB + fullPriceB + priceForC + priceForD +
                    priceForE + fullPriceA2 + offerA2 + offerPriceF
                    + fullPriceG + full;
        } else return -1;

    }
}
