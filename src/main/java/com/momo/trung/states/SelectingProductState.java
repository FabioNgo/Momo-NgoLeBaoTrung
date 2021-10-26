package com.momo.trung.states;

import com.momo.trung.Main;
import com.momo.trung.enums.DrinkEnum;
import com.momo.trung.enums.StateEnum;
import com.momo.trung.exceptions.WrongStateException;

import java.util.Scanner;

public class SelectingProductState extends StateImpl {
    @Override
    public void doState() {
        if (StateImpl.getState() != StateEnum.SELECTING_PRODUCT){
            throw new WrongStateException(StateEnum.SELECTING_PRODUCT);
        }
        DrinkEnum[] options = DrinkEnum.values();
        String question = "Please select your drink. Your balance is: " + getTotalDeposit();
        int selected;
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d:%s (%d)\n", i + 1,options[i].getShowingName(),options[i].getPrice());
        }
        System.out.print("Your choice? ");
        Scanner scanner = new Scanner(System.in);
        selected = scanner.nextInt();
        DrinkEnum selectedDrink = options[selected - 1];
        if (selectedDrink.getPrice() > StateImpl.getTotalDeposit()){
            System.out.println("Please deposit more");
            moveToState(StateEnum.ASKING_DEPOSIT);
        }else{
            setSelectedDrink(selectedDrink);
            moveToState(StateEnum.ASKING_CONFIRMATION);
        }
    }
}
