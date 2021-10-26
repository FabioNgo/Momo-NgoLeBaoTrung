package com.momo.trung.states;

import com.momo.trung.enums.StateEnum;
import com.momo.trung.exceptions.WrongStateException;

import java.util.Scanner;

public abstract class AskingState extends StateImpl {

    protected abstract StateEnum getYesStateEnum();
    protected abstract StateEnum getNoStateEnum();
    protected abstract String getQuestion();
    protected abstract StateEnum getExpectedStateEnum();
    @Override
    public void doState() {
        if (getState() != getExpectedStateEnum()) {
            throw new WrongStateException(getExpectedStateEnum());
        }
        while (true) {
            System.out.println(getQuestion());
            System.out.println("0. No");
            System.out.println("1. Yes");
            System.out.print("Your choice? ");
            Scanner scanner = new Scanner(System.in);
            int selected = scanner.nextInt();
            if (selected == 1) {
                moveToState(getYesStateEnum());
                return;
            }
            if (selected == 0) {
                moveToState(getNoStateEnum());
                return;
            }
            System.out.println("Please select again");
        }
    }
}
