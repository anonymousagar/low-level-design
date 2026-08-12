package Atm;

public class AtmMachine {
    CashDispenser cashDispenser;
    
    public AtmMachine(){
        this.cashDispenser= new CashDispenser();
    }

    public void getCash(int amount){
        try{
            cashDispenser.getDispenser().getCash(amount);
        }
        catch(InvalidAmountException ex){
            System.out.println("Invalid Amount ");
        }
    }
}
