package com.momo.trung.enums;
public enum DrinkEnum {
    COKE(10000,"Coke"),
    PEPSI(10000,"Pepsi"),
    SODA(20000,"Soda");
    private final int price;
    private final String showingName;

    DrinkEnum(int price, String name){
        this.price = price;
        this.showingName = name;
    }

    public int getPrice() {
        return price;
    }

    public String getShowingName() {
        return showingName;
    }
}
