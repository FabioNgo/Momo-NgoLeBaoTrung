package com.momo.trung.states;

import com.momo.trung.enums.StateEnum;

public class AskingConfirmationState extends AskingState {
    @Override
    protected StateEnum getYesStateEnum() {
        return StateEnum.BOUGHT_PRODUCT;
    }

    @Override
    protected StateEnum getNoStateEnum() {
        return StateEnum.ASKING_NEXTDAY;
    }

    @Override
    protected String getQuestion() {
        return "Do you confirm to buy?";
    }

    @Override
    protected StateEnum getExpectedStateEnum() {
        return StateEnum.ASKING_CONFIRMATION;
    }
}
