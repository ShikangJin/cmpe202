/*
	Please read State interface for methods explanation
*/
public class SoldOutState implements State {
    
    GumballMachine gumballMachine;
 	
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 	
 	/*
		inserting coin does not work in current state
 	*/
 	@Override
	public void insertCoin(int coin) {
		System.out.println("You can't insert a coin, the machine is sold out\n");
	}
 	
 	/*
		ejecting coin does not work in current state
 	*/
 	@Override
	public void ejectCoin() {
		System.out.println("You can't eject, you haven't inserted a coin yet\n");
	}
	
	/*
		turning crank does not work in current state
	*/
	@Override 
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs\n");
	}
 	
 	/*
		dispensing gumball does not work in current state
 	*/
 	@Override
	public void dispense() {
		System.out.println("No gumball dispensed\n");
	}

 	/*
		print message for this state
 	*/
	public String toString() {
		return "sold out\n";
	}
}
