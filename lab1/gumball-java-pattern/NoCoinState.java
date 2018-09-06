/*
	Please read State interface for methods explanation
*/
public class NoCoinState implements State {
    
    GumballMachine gumballMachine;
 
    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /*
		inserting coin changes current state to hasCoinState
    */
 	@Override
	public void insertCoin(int coin) {	
		System.out.println("You inserted " + coin + " cents");
		gumballMachine.setState(gumballMachine.getHasCoinState());			
	}
 	
 	/*
		ejecting coin does not work in current state
 	*/
 	@Override
	public void ejectCoin() {
		System.out.println("You haven't inserted any coin\n");
	}
 	
 	/*
		turning crank does not work in current state
 	*/
 	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter\n");
	}
 	
	/*
		dispensing gumball does not work in current state
	*/
 	@Override
	public void dispense() {
		System.out.println("You need to pay first\n");
	} 
 	
 	/*
		print message for this state
 	*/
	public String toString() {
		return "waiting for coins\n";
	}
}
