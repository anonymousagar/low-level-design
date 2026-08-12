package Atm.Dispenser;

import Atm.CashDispenser;
import Atm.InvalidAmountException;

public class Dispenser200 extends CashDispenser {
    CashDispenser nextCashDispenser;

    public Dispenser200(CashDispenser cashDispenser){
        this.nextCashDispenser = cashDispenser;
    }

    public void getCash(int amount) throws InvalidAmountException{
        int notesCount = amount/200;
        System.out.println("200 notes dispensed : "+ notesCount);
        nextCashDispenser.getCash(amount%200);
    }
}
