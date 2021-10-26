package com.momo.trung.exceptions;

import com.momo.trung.enums.StateEnum;
import com.momo.trung.states.StateImpl;

public class WrongStateException extends RuntimeException {
    private final StateEnum expected;

    public WrongStateException(StateEnum expected){
        this.expected = expected;
    }

    @Override
    public String getMessage() {
        return "Wrong state: Expected: " + expected.name() + ", actual: " + StateImpl.getState().name();
    }
}
