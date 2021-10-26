package com.momo.trung.states;

import com.momo.trung.enums.StateEnum;

public class CancelState extends StateImpl {
    @Override
    public void doState() {
        System.out.println("You will be refunded: "+ getTotalDeposit());
        setSelectedDrink(null);
        setTotalDeposit(0);
    }
}
