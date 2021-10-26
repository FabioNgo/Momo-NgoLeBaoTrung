package com.momo.trung.states;

import com.momo.trung.entities.Promotion;
import com.momo.trung.entities.User;
import com.momo.trung.enums.StateEnum;

public class NextDayState extends StateImpl {
    @Override
    public void doState() {
        Promotion.moveNextDay();
        User.getInstance().reset();
        moveToState(StateEnum.START);
    }
}
