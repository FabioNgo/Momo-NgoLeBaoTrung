package com.momo.trung.states;

import com.momo.trung.Promotion;
import com.momo.trung.enums.StateEnum;

public class StartState  extends StateImpl{
    @Override
    public void doState() {
        setTotalDeposit(0);
        setSelectedDrink(null);
        System.out.println("Welcome to our service");
        System.out.println("Winrate: " + Promotion.getWinrate()*100 + "%");
        System.out.println("promotion budget: " + Promotion.LIMIT);
        moveToState(StateEnum.ASKING_DEPOSIT);
    }
}
