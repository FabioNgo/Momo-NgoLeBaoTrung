package com.momo.trung.states;

import com.momo.trung.enums.NoteEnum;
import com.momo.trung.enums.StateEnum;
import com.momo.trung.exceptions.WrongStateException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DoingDepositState extends StateImpl {

    @Override
    public void doState() {
        if(StateImpl.getState() != StateEnum.DOING_DEPOSIT){
            throw new WrongStateException(StateEnum.DOING_DEPOSIT);
        }
        while(true){
            System.out.println("Your balance: " + StateImpl.getTotalDeposit());
            System.out.println("Please enter number of note you want to deposit in the format <note><space><amount>. Where note is the options of the following notes");
            List<String> notes = Arrays.stream(NoteEnum.values()).map(NoteEnum::getShowingName).collect(Collectors.toList());
            for (int i = 0; i < notes.size(); i++) {
                System.out.printf("%d:%s\n", i + 1,notes.get(i));
            }
            System.out.print("Your choice?: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            int  amount = scanner.nextInt();
            NoteEnum note = Arrays.stream(NoteEnum.values()).filter(n->n.getShowingName().equals(notes.get(option-1))).findFirst().orElse(null);
            if (note != null){
                int value = note.getValue()*amount;
                StateImpl.setTotalDeposit(StateImpl.getTotalDeposit() + value);
                moveToState(StateEnum.ASKING_DEPOSIT);
                return;
            }else{
                System.out.println("Please key in again");
            }
        }
    }
}
