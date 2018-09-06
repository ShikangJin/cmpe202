

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
	public void insertCoin(int coin) {
		System.out.println("Please wait, we're already giving you a gumball\n");
	}
 
	public void ejectCoin() {
		System.out.println("Sorry, you already turned the crank\n");
	}
 
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!\n");
	}
 
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			if (gumballMachine.getCoin() > 0) {
				gumballMachine.setState(gumballMachine.getHasCoinState());
			} else {
				gumballMachine.setState(gumballMachine.getNoCoinState());
			}
		} else {
			System.out.println("Oops, out of gumballs!\n");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
 
	public String toString() {
		return "dispensing a gumball\n";
	}
}


