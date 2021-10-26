package com.momo.trung;

import com.momo.trung.enums.DrinkEnum;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static User instance;
    public static User getInstance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }
    private List<DrinkEnum> productBought = new ArrayList<>();
    public void addBoughtProduct(DrinkEnum drink){
        productBought.add(drink);
    }

    public List<DrinkEnum> getProductBought() {
        return productBought;
    }

    public void reset() {
        this.productBought = new ArrayList<>();
    }
}
