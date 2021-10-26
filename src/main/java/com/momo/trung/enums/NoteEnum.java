package com.momo.trung.enums;

public enum NoteEnum {
    N10000(10000,"10000"),
    N20000(1000,"20000"),
    N50000(20000,"50000"),
    N100000(100000,"100000"),
    N200000(200000,"200000");
    private final int value;
    private final String showingName;

    NoteEnum(int price, String name){
        this.value = price;
        this.showingName = name;
    }

    public int getValue() {
        return value;
    }

    public String getShowingName() {
        return showingName;
    }
}
