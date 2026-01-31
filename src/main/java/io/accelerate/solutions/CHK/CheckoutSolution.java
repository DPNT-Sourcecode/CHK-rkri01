package io.accelerate.solutions.CHK;

import java.util.*;

import static io.accelerate.solutions.CHK.Offers.*;
import static io.accelerate.solutions.CHK.Prices.getPriceForSku;
import static io.accelerate.solutions.CHK.Prices.populatePrices;

public class CheckoutSolution {
    public HashMap<String, Integer> prices = populatePrices();

    public Integer checkout(String skus) {
        boolean illegalInput = false;

        int priceForC = 0;
        int priceForD = 0;
        int priceForE = 0;
        int offerPriceF = 0;
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

        Map<String, Integer> skuCount = getSkuCountFromSkus(skus, illegalInput);

        for (int i = 0; i < skus.length(); i++) {
            String letter = skus.substring(i, i+1);
            if (CheckSku.isValid(letter, illegalInput)) {
                skuCount.put(letter, skuCount.getOrDefault(letter, 0) + 1);
            } else {
                illegalInput = true;
                return -1;
            }
        }

        Set<String> offerLetterSet = new HashSet<>();
        offerLetterSet.add("S");
        offerLetterSet.add("T");
        offerLetterSet.add("X");
        offerLetterSet.add("Y");
        offerLetterSet.add("Z");

        Group group = costOfGroupOffer(skuCount, offerLetterSet, 3, 45);
        NavigableSet<Item> treeSet = createTreeSet(prices, offerLetterSet);
        skus = updateSkuCountForGroupOffer(skus, treeSet, group.numberOfItemsToRemoveFromInput());
        Map<String, Integer> skuCountGroupOfferRemoved = getSkuCountFromSkus(skus, illegalInput);

        if (Offers.isValidForOfferBuyXGetOneFree(skuCountGroupOfferRemoved,  "F", 2)) {
            Offers.updateSkuCountMapForOfferBuyXGetOneFree(skuCountGroupOfferRemoved, "F", 2);
        }

        if (Offers.isValidForOfferBuyXGetOneFree(skuCountGroupOfferRemoved,  "U", 3)) {
            Offers.updateSkuCountMapForOfferBuyXGetOneFree(skuCountGroupOfferRemoved, "U", 3);
        }
        if (Offers.isValidForOfferBuyXGetDifferentSkuFree(skuCountGroupOfferRemoved, "E", 2, "B")) {
            Offers.updateSkuCountMapForOfferBuyXGetDifferentSkuFree(skuCountGroupOfferRemoved, "E", 2, "B");
        }
        if (Offers.isValidForOfferBuyXGetDifferentSkuFree(skuCountGroupOfferRemoved, "N", 3, "M")) {
            Offers.updateSkuCountMapForOfferBuyXGetDifferentSkuFree(skuCountGroupOfferRemoved, "N", 3, "M");
        }
        if (Offers.isValidForOfferBuyXGetDifferentSkuFree(skuCountGroupOfferRemoved, "R", 3, "Q")) {
            Offers.updateSkuCountMapForOfferBuyXGetDifferentSkuFree(skuCountGroupOfferRemoved, "R", 3, "Q");
        }

        Reduced a = Offers.validOfferCheaperInMultiples(skuCountGroupOfferRemoved, prices, "A", 3, 130, 5, 200);
        Reduced h = Offers.validOfferCheaperInMultiples(skuCountGroupOfferRemoved, prices, "H", 5, 45, 10, 80);
        Reduced v = Offers.validOfferCheaperInMultiples(skuCountGroupOfferRemoved, prices, "V", 2, 90, 3, 130);

        SpecialOffer b = Offers.validOfferBuyXgetForCheaper(skuCountGroupOfferRemoved, prices, "B", 2, 45);
        SpecialOffer k = Offers.validOfferBuyXgetForCheaper(skuCountGroupOfferRemoved, prices, "K", 2, 120);
        SpecialOffer p = Offers.validOfferBuyXgetForCheaper(skuCountGroupOfferRemoved, prices, "P", 5, 200);
        SpecialOffer q = Offers.validOfferBuyXgetForCheaper(skuCountGroupOfferRemoved, prices, "Q", 3, 80);

        priceForC = getPriceForSku(skuCountGroupOfferRemoved, prices, "C");
        priceForD = getPriceForSku(skuCountGroupOfferRemoved, prices, "D");
        priceForE = getPriceForSku(skuCountGroupOfferRemoved, prices, "E");
        offerPriceF = getPriceForSku(skuCountGroupOfferRemoved, prices, "F");
        fullPriceG = getPriceForSku(skuCountGroupOfferRemoved, prices, "G");
        fullPriceI = getPriceForSku(skuCountGroupOfferRemoved, prices, "I");
        fullPriceJ = getPriceForSku(skuCountGroupOfferRemoved, prices, "J");
        fullPriceL = getPriceForSku(skuCountGroupOfferRemoved, prices, "L");
        fullPriceM = getPriceForSku(skuCountGroupOfferRemoved, prices, "M");
        fullPriceN = getPriceForSku(skuCountGroupOfferRemoved, prices, "N");
        fullPriceO = getPriceForSku(skuCountGroupOfferRemoved, prices, "O");
        fullPriceR = getPriceForSku(skuCountGroupOfferRemoved, prices, "R");
        fullPriceS = getPriceForSku(skuCountGroupOfferRemoved, prices, "S");
        fullPriceT = getPriceForSku(skuCountGroupOfferRemoved, prices, "T");
        fullPriceU = getPriceForSku(skuCountGroupOfferRemoved, prices, "U");
        fullPriceW = getPriceForSku(skuCountGroupOfferRemoved, prices, "W");
        fullPriceX = getPriceForSku(skuCountGroupOfferRemoved, prices, "X");
        fullPriceY = getPriceForSku(skuCountGroupOfferRemoved, prices, "Y");
        fullPriceZ = getPriceForSku(skuCountGroupOfferRemoved, prices, "Z");

        if (illegalInput == false) {
            return a.offer() + a.fullPriced() + a.fullPrice2() + a.offer2()
                    + h.offer() + h.fullPriced() + h.fullPrice2() + h.offer2()
                    + v.offer() + v.fullPriced() + v.fullPrice2() + v.offer2()
                    + b.offer() + b.fullPriced()
                    + k.offer() + k.fullPriced()
                    + p.offer() + p.fullPriced()
                    + q.offer() + q.fullPriced()
                    + priceForC + priceForD + priceForE + offerPriceF + fullPriceN + fullPriceR + fullPriceU
                    + fullPriceG + fullPriceI + fullPriceJ + fullPriceL + fullPriceM + fullPriceO
                    + fullPriceS + fullPriceT + fullPriceW + fullPriceX + fullPriceY + fullPriceZ + group.priceOfItems();
        } else return -1;
    }

    private Map<String, Integer> getSkuCountFromSkus(String skus, boolean illegalInput){
        Map<String, Integer> skuCount = new HashMap<>();
        for (int i = 0; i < skus.length(); i++) {
            String letter = skus.substring(i, i+1);
            if (CheckSku.isValid(letter, illegalInput)) {
                skuCount.put(letter, skuCount.getOrDefault(letter, 0) + 1);
            } else illegalInput = true;
        }
        return skuCount;
    }
}
