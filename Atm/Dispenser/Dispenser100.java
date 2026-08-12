package Atm.Dispenser;

import Atm.CashDispenser;
import Atm.InvalidAmountException;

public class Dispenser100 extends CashDispenser{
     CashDispenser nextCashDispenser;

     public Dispenser100(){
        this.nextCashDispenser = null;
     }

    public Dispenser100(CashDispenser cashDispenser){
        this.nextCashDispenser = cashDispenser;
    }

    public void getCash(int amount) throws InvalidAmountException{
        int notesCount = amount/100;
        System.out.println("100 notes dispensed : "+ notesCount);
        if(amount%100 != 0){
            throw new InvalidAmountException();
        }
    }
    
}
