package io.accelerate.solutions.CHK;

import java.util.HashMap;
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

    public static boolean isValidForOfferBuyXGetDifferentSkuFree(Map<String, Integer> skuCount, String buy, int buyCount, String free) {
        boolean validOffer = false;
        if ((skuCount.get(buy) == null ? 0 : skuCount.get(buy)) >= buyCount
                && (skuCount.get(free) == null ? 0 : skuCount.get(free)) > 0) {
            validOffer = true;
        }
        return validOffer;
    }

    public static void updateSkuCountMapForOfferBuyXGetDifferentSkuFree(Map<String, Integer> skuCount, String buy, int buyCount, String free) {
        int freeOne = skuCount.get(buy) / buyCount;
        int currentNumberInTrolly = skuCount.get(free);
        if (currentNumberInTrolly >= freeOne) {
            skuCount.put(free, currentNumberInTrolly - freeOne);
        }
    }

    public static Reduced validOfferCheaperInMultiples(Map<String, Integer> skuCount, HashMap<String, Integer> prices, String letter, int firstCount, int firstPrice, int secondCount, int secondPrice) {
        int offer = 0;
        int fullPrice = 0;
        int offer2 = 0;
        int fullPrice2 = 0;
        int numberOfItem = skuCount.get(letter) == null ? 0 : skuCount.get(letter);
        if (numberOfItem >= secondCount) {
            int numberOfOffer = numberOfItem / secondCount;
            int numberOfFullPrice = numberOfItem % secondCount;
            offer = numberOfOffer * secondPrice;
            if (numberOfFullPrice >= firstCount) {
                int numberOfOffer2 = numberOfFullPrice / firstCount;
                int numberOfFullPrice2 = numberOfFullPrice % firstCount;
                offer2 = numberOfOffer2 * firstPrice;
                fullPrice2 = numberOfFullPrice2 * prices.get(letter);
            } else fullPrice = numberOfFullPrice * prices.get(letter);
        } else if (numberOfItem >= firstCount) {
            int numberOfOffer = numberOfItem / firstCount;
            int numberOfFullPrice = numberOfItem % firstCount;
            offer = numberOfOffer * firstPrice;
            fullPrice = numberOfFullPrice * prices.get(letter);
        } else {
            fullPrice = Prices.getPriceForSku(skuCount, prices, letter);
        }
        return new Reduced(offer, fullPrice, offer2, fullPrice2);
    }

}


