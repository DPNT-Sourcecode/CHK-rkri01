package io.accelerate.solutions.CHK;

import java.util.Map;

public class Offers {

    /*
    buyCount is how many are paid for, not including free ones
     */
    public static boolean isValidForOfferBuyXGetOneFree(Map<String, Integer> skuCount, String letter, int buyCount) {
        boolean validOffer = false;
        if ((skuCount.get(letter) == null ? 0 : skuCount.get(letter)) >= (buyCount + 1)) {
            validOffer = true;
        }
        return validOffer;
    }

    public static void updateSkuCountMapForOfferBuyXGetOneFree(Map<String, Integer> skuCount, String letter, int buyCount) {
        int free = skuCount.get(letter) / (buyCount + 1);
        int currentNumberInTrolly = skuCount.get(letter);
        if (currentNumberInTrolly >= free) {
            skuCount.put(letter, currentNumberInTrolly - free);
        }
    }
}
