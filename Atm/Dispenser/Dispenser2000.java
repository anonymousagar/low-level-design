package Atm.Dispenser;

import Atm.CashDispenser;
import Atm.InvalidAmountException;

public class Dispenser2000 extends CashDispenser{
    CashDispenser nextCashDispenser;

    public Dispenser2000(CashDispenser cashDispenser){
        this.nextCashDispenser = cashDispenser;
    }

    public void getCash(int amount) throws InvalidAmountException{
        int notesCount = amount/2000;
        System.out.println("2000 notes dispensed : "+ notesCount);
        nextCashDispenser.getCash(amount%2000);
    }

}
