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

        if (Offers.isValidForOfferBuyXGetOneFree(skuCount,  "F", 2)) {
            Offers.updateSkuCountMapForOfferBuyXGetOneFree(skuCount, "F", 2);
        }

        if (Offers.isValidForOfferBuyXGetOneFree(skuCount,  "U", 3)) {
            Offers.updateSkuCountMapForOfferBuyXGetOneFree(skuCount, "U", 3);
        }
        if (Offers.isValidForOfferBuyXGetDifferentSkuFree(skuCount, "E", 2, "B")) {
            Offers.updateSkuCountMapForOfferBuyXGetDifferentSkuFree(skuCount, "E", 2, "B");
        }
        if (Offers.isValidForOfferBuyXGetDifferentSkuFree(skuCount, "N", 3, "M")) {
            Offers.updateSkuCountMapForOfferBuyXGetDifferentSkuFree(skuCount, "N", 3, "M");
        }
        if (Offers.isValidForOfferBuyXGetDifferentSkuFree(skuCount, "R", 3, "Q")) {
            Offers.updateSkuCountMapForOfferBuyXGetDifferentSkuFree(skuCount, "R", 3, "Q");
        }

        Reduced a = Offers.validOfferCheaperInMultiples(skuCount, prices, "A", 3, 130, 5, 200);
        Reduced h = Offers.validOfferCheaperInMultiples(skuCount, prices, "H", 5, 45, 10, 80);
        Reduced v = Offers.validOfferCheaperInMultiples(skuCount, prices, "V", 2, 90, 3, 130);

        SpecialOffer b = Offers.validOfferBuyXgetForCheaper(skuCount, prices, "B", 2, 45);
        SpecialOffer k = Offers.validOfferBuyXgetForCheaper(skuCount, prices, "K", 2, 150);
        SpecialOffer p = Offers.validOfferBuyXgetForCheaper(skuCount, prices, "P", 5, 200);
        SpecialOffer q = Offers.validOfferBuyXgetForCheaper(skuCount, prices, "Q", 3, 80);

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

