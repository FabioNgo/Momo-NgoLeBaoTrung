package com.momo.trung.states;

import com.momo.trung.enums.DrinkEnum;
import com.momo.trung.enums.StateEnum;

public abstract class StateImpl implements State {
    private static StateEnum state = StateEnum.START;
    private static int totalDeposit = 0;
    private static DrinkEnum selectedDrink = null;

    public static StateEnum getState() {
        return state;
    }

    public static DrinkEnum getSelectedDrink() {
        return selectedDrink;
    }

    public static int getTotalDeposit() {
        return totalDeposit;
    }

    public static void setState(StateEnum state) {
        StateImpl.state = state;
    }

    public static void setTotalDeposit(int totalDeposit) {
        StateImpl.totalDeposit = totalDeposit;
    }

    public static void setSelectedDrink(DrinkEnum selectedDrink) {
        StateImpl.selectedDrink = selectedDrink;
    }
    public static void moveToState(StateEnum stateEnum){
        setState(stateEnum);
        StateFactory.getState(stateEnum).doState();
    }
}
