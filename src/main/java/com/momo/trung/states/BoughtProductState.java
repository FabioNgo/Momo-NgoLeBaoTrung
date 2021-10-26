package com.momo.trung.states;

import com.momo.trung.entities.Promotion;
import com.momo.trung.entities.User;
import com.momo.trung.enums.DrinkEnum;
import com.momo.trung.enums.StateEnum;

import java.util.stream.Collectors;

public class BoughtProductState extends StateImpl {
    @Override
    public void doState() {
        System.out.println("Thank you for buying "+ getSelectedDrink().getShowingName());
        User.getInstance().addBoughtProduct(getSelectedDrink());
        setTotalDeposit(getTotalDeposit() - getSelectedDrink().getPrice());
        setSelectedDrink(null);
        System.out.println("You have bought: "+ User.getInstance().getProductBought().stream().map(
                DrinkEnum::getShowingName).collect(
                Collectors.joining(", ")));
        DrinkEnum receivedFreeProduct = Promotion.isReceivedFreeProduct();
        if(receivedFreeProduct != null){
            System.out.println("You received a free "+ getSelectedDrink().getShowingName());
        }
        moveToState(StateEnum.ASKING_DEPOSIT);
    }
}
