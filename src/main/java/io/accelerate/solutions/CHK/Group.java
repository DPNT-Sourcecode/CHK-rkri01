package io.accelerate.solutions.CHK;

public record Group(boolean isValidOffer, int numberOfItemsPurchased, int priceOfItems, int numberOfItemsToRemoveFromInput) implements Offer{
}
