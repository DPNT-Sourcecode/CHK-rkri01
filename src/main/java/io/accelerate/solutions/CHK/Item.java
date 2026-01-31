package io.accelerate.solutions.CHK;

public class Item implements Comparable<Item> {

    private String sku;
    private int price;

    public Item(String sku, int price) {
        this.sku = sku;
        this.price = price;
    }

    @Override
    public int compareTo(Item otherItem) {
        if (this.price >= otherItem.price) {
            return 1;
        } else if (this.price < otherItem.price) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getPrice() {
        return price;
    }
    public String getSku() {
        return this.sku;
    }
}
