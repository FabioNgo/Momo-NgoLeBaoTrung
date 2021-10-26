package com.momo.trung;

import com.momo.trung.enums.DrinkEnum;

import java.util.List;
import java.util.Random;

public class Promotion {
    private static double winrate = 0.1;
    public static final int LIMIT = 50000;
    private static int limit = 50000;
    private static DrinkEnum is3ConsecutivePurchase(){
        List<DrinkEnum> productBought = User.getInstance().getProductBought();
        if (productBought.size() < 3){
            return null;
        }

        for(int i = 0 ; i < productBought.size() - 2; i++ ){
            DrinkEnum drink1 = productBought.get(i);
            DrinkEnum drink2 = productBought.get(i+1);
            DrinkEnum drink3 = productBought.get(i+2);
            if (drink1 == drink2 && drink3 == drink2){
                return drink1;
            }
        }
        return null;
    }
    public static DrinkEnum isReceivedFreeProduct(){
        DrinkEnum consecutivePurchaseDrink = is3ConsecutivePurchase();
        if(consecutivePurchaseDrink == null){
            return null;
        }
        boolean receivedFreeProductFromWinrate = isReceivedFreeProductFromWinrate();
        if(receivedFreeProductFromWinrate){
            if(limit - consecutivePurchaseDrink.getPrice() < 0){
                return null;
            }else{
                limit -= consecutivePurchaseDrink.getPrice();
                return consecutivePurchaseDrink;
            }
        }else{
            return null;
        }
    }
    private static boolean isReceivedFreeProductFromWinrate() {
        Random random = new Random(System.currentTimeMillis());
        int range = (int) (1 / winrate);
        int i = random.nextInt(range);
        return i == 0;
    }

    public static void moveNextDay() {
        if(limit > 0){
            winrate = winrate*1.5;
            winrate = ((int)(winrate * 10000))/10000.0;
            if( winrate > 1){
                winrate = 1;
            }
            limit = LIMIT;
        }
    }

    public static double getWinrate() {
        return winrate;
    }
}
