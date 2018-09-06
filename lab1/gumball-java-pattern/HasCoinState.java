import java.util.Random;

public class HasCoinState implements State {
	
	GumballMachine gumballMachine;
 
	public HasCoinState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertCoin(int coin) {
		if (gumballMachine.getCoin() < gumballMachine.getCost()) {
			System.out.println("You inserted " + coin + " cents");
			return;
		}
		System.out.println("You can't insert another coin\n");
	}
 
	public void ejectCoin() {
		int curCoin = gumballMachine.getCoin();
		System.out.println(curCoin + " cents returned\n");
		gumballMachine.setState(gumballMachine.getNoCoinState());
	}
 
	public void turnCrank() {
		int curCost = gumballMachine.getCost();
		if (gumballMachine.getCoin() < curCost) {
			System.out.println("You need to insert " + curCost + " cents\n");
			return;
		}
		System.out.println("You turned...\n");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void dispense() {
        System.out.println("No gumball dispensed\n");
    }
 
	public String toString() {
		if (gumballMachine.getCoin() < gumballMachine.getCost()) {
			return "waiting for coins\n";
		}
		return "waiting for turn of crank\n";
	}
}
