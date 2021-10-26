package com.momo.trung.states;

import com.momo.trung.enums.StateEnum;
import com.momo.trung.exceptions.WrongStateException;

import java.util.Scanner;

public class AskingSelectingProductState extends AskingState {
    @Override
    protected StateEnum getYesStateEnum() {
        return StateEnum.SELECTING_PRODUCT;
    }

    @Override
    protected StateEnum getNoStateEnum() {
        return StateEnum.ASKING_NEXTDAY;
    }

    @Override
    protected String getQuestion() {
        return "Do you want select a product?";
    }

    @Override
    protected StateEnum getExpectedStateEnum() {
        return StateEnum.ASKING_SELECTING_PRODUCT;
    }
}
