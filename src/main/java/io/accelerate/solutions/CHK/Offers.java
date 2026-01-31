package io.accelerate.solutions.CHK;

import java.util.*;

public class Offers {

    public static Group costOfGroupOffer(Map<String, Integer> skuCount, Set<String> letters, int buyCount, int offerPrice) {
        boolean validOffer = false;
        int numberOfItemsPurchased = 0;
        for (String letter : letters) {
            skuCount.putIfAbsent(letter, 0);
            numberOfItemsPurchased += skuCount.get(letter);
        }
        if (numberOfItemsPurchased >= buyCount) {
            validOffer = true;
        }
        return new Group(validOffer, numberOfItemsPurchased, offerPrice * (numberOfItemsPurchased / buyCount),
                (numberOfItemsPurchased / buyCount) * buyCount);
    }

    /*
        Have a prefernce to select the more expensive items in the Group Offer first.
     */
    public static NavigableSet<Item> createTreeSet(HashMap<String, Integer> prices, Set<String> letters){
        TreeSet<Item> treeSet = new TreeSet<>();
        for (String letter : letters) {
            treeSet.add(new Item(letter, prices.get(letter)));
        }
        return treeSet.descendingSet();
    }

    public static String updateSkuCountForGroupOffer(String skus, NavigableSet<Item> treeSet, int numberOfItemsToRemove) {
        int itemsToRemove = numberOfItemsToRemove;
        for (Item item : treeSet) {
            int occurrence = skus.length() - skus.replace(item.getSku(), "").length();
            if (itemsToRemove > 0 ){
                if (itemsToRemove >= occurrence) {
                    itemsToRemove -= occurrence;
                    skus = skus.replace(item.getSku(), "");
                } else {
                    for (int i = 0; i < itemsToRemove; i++){
                        itemsToRemove -= 1;
                        skus = skus.replaceFirst(item.getSku(), "");
                    }
                }
            }
        }
        return skus;
    }

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

    public static SpecialOffer validOfferBuyXgetForCheaper(Map<String, Integer> skuCount, HashMap<String, Integer> prices, String letter, int buyCount, int offerPrice) {
        int offer = 0;
        int fullPrice = 0;
        int numberOf = skuCount.get(letter) == null ? 0 : skuCount.get(letter);
        if (numberOf >= buyCount) {
            int numberOfOffer = numberOf / buyCount;
            int numberOfFullPrice = numberOf % buyCount;
            offer = numberOfOffer * offerPrice;
            fullPrice = numberOfFullPrice * prices.get(letter);
        } else {
            fullPrice = Prices.getPriceForSku(skuCount, prices, letter);
        }
        return new SpecialOffer(offer, fullPrice);
    }

}

