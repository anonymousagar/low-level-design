package Atm;

import Atm.Dispenser.*;

public class CashDispenser {
    CashDispenser nextCashDispenser;

    public CashDispenser(){
    }

    public CashDispenser(CashDispenser cashDispenser){
        this.nextCashDispenser = cashDispenser;
    }

    public void getCash(int amount) throws InvalidAmountException{
        //doNothing
    }

    public CashDispenser getDispenser(){
        return new Dispenser2000(new Dispenser500(new Dispenser200(new Dispenser100())));
    }

}
