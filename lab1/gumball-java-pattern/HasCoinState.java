import java.util.Random;

/*
	Please read State interface for methods explanation
*/
public class HasCoinState implements State {
	
	GumballMachine gumballMachine;
 
	public HasCoinState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  	
  	/*
		inserting a coin does not change current state
  	*/
  	@Override
	public void insertCoin(int coin) {
		if (gumballMachine.getCoin() < gumballMachine.getCost()) {
			System.out.println("You inserted " + coin + " cents");
			return;
		}
		System.out.println("You can't insert another coin\n");
	}
 	
 	/*
		ejecting coin changes state to noCoinState
 	*/
 	@Override
	public void ejectCoin() {
		int curCoin = gumballMachine.getCoin();
		System.out.println(curCoin + " cents returned\n");
		gumballMachine.setState(gumballMachine.getNoCoinState());
	}
 	
 	/*
		turning crank changes state to soldState if the amount of coin in machine reaches the requirement 
 	*/
 	@Override
	public void turnCrank() {
		int curCost = gumballMachine.getCost();
		if (gumballMachine.getCoin() < curCost) {
			System.out.println("You need to insert " + curCost + " cents\n");
			return;
		}
		System.out.println("You turned...\n");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	/*
		despensing gumball does not work in current state
	*/
	@Override
    public void dispense() {
        System.out.println("No gumball dispensed\n");
    }
 	
 	/*
		print message for this state
 	*/
	public String toString() {
		if (gumballMachine.getCoin() < gumballMachine.getCost()) {
			return "waiting for coins\n";
		}
		return "waiting for turn of crank\n";
	}
}
