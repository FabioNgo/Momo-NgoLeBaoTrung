package com.momo.trung.states;

import com.momo.trung.enums.StateEnum;
import com.momo.trung.exceptions.WrongStateException;

import java.util.Scanner;

public class AskingDepositState extends AskingState {
    @Override
    protected StateEnum getNoStateEnum() {
        return StateEnum.ASKING_SELECTING_PRODUCT;
    }

    @Override
    protected StateEnum getYesStateEnum() {
        return StateEnum.DOING_DEPOSIT;
    }

    @Override
    protected String getQuestion() {
        return "Do you want to Deposit?";
    }

    @Override
    protected StateEnum getExpectedStateEnum() {
        return StateEnum.ASKING_DEPOSIT;
    }
}
