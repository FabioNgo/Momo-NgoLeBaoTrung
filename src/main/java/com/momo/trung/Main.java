package com.momo.trung;

import com.momo.trung.enums.StateEnum;

import static com.momo.trung.states.StateImpl.moveToState;

public class Main {
    public static void main(String... arg){
        moveToState(StateEnum.START);
    }
}
