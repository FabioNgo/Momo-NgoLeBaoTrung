package com.momo.trung.states;

import com.momo.trung.enums.StateEnum;

public class StateFactory {
    public static State getState(StateEnum state){
        if(state == StateEnum.START){
            return new StartState();
        }
        if (state == StateEnum.DOING_DEPOSIT){
            return new DoingDepositState();
        }
        if (state == StateEnum.SELECTING_PRODUCT){
            return new SelectingProductState();
        }
        if (state == StateEnum.ASKING_CONFIRMATION){
            return new AskingConfirmationState();
        }
        if (state == StateEnum.CANCELLED){
            return new CancelState();
        }
        if (state == StateEnum.ASKING_DEPOSIT){
            return new AskingDepositState();
        }
        if (state == StateEnum.ASKING_SELECTING_PRODUCT){
            return new AskingSelectingProductState();
        }
        if (state == StateEnum.NEXT_DAY){
            return new NextDayState();
        }
        if (state == StateEnum.BOUGHT_PRODUCT){
            return new BoughtProductState();
        }
        if (state == StateEnum.ASKING_NEXTDAY){
            return new AskingNextDayState();
        }
        throw new RuntimeException("State is not supported");
    }
}
