package com.momo.trung.states;

import com.momo.trung.enums.StateEnum;

import java.util.Scanner;

public class AskingNextDayState extends AskingState {
    @Override
    protected StateEnum getYesStateEnum() {
        return StateEnum.NEXT_DAY;
    }

    @Override
    protected StateEnum getNoStateEnum() {
        return StateEnum.CANCELLED;
    }

    @Override
    protected String getQuestion() {
        return "Do you want to move to the next day ?";
    }

    @Override
    protected StateEnum getExpectedStateEnum() {
        return StateEnum.ASKING_NEXTDAY;
    }
}
