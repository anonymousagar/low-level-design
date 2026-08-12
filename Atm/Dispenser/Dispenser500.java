package Atm.Dispenser;

import Atm.CashDispenser;
import Atm.InvalidAmountException;

public class Dispenser500 extends CashDispenser{
    CashDispenser nextCashDispenser;

    public Dispenser500(CashDispenser cashDispenser){
        this.nextCashDispenser = cashDispenser;
    }
    
    public void getCash(int amount) throws InvalidAmountException{
        int notesCount = amount/500;
        System.out.println("500 notes dispensed : "+ notesCount);
        nextCashDispenser.getCash(amount%500);
    }
}
