package VendingMachine.State;

import java.util.List;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class HasMoneyState extends VendingMachineState {

    public HasMoneyState(){
         System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }
    
}
