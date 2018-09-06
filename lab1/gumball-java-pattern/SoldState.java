
/*
	Please read State interface for methods explanation
*/
public class SoldState implements State {
 
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    /*
		inserting coin does not work in current state
    */
    @Override   
	public void insertCoin(int coin) {
		System.out.println("Please wait, we're already giving you a gumball\n");
	}
 	
 	/*
		ejecting coin does not work in current state
 	*/
 	@Override
	public void ejectCoin() {
		System.out.println("Sorry, you already turned the crank\n");
	}

	/*
		turning crank does not work in current state
	*/
 	@Override
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!\n");
	}

	/*
		dispensing gumball releases a gumball, then:
			changes current state to soldOutState if there is no gumball in machine
			changes current state to noCoinState if there is no coin but one or more gumball(s) in machine 
			changes current state to hasCoinState if there are coins and one or more gumball(s) in machine
	*/
 	@Override 
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
 	
 	/*
		print message for this state
 	*/
	public String toString() {
		return "dispensing a gumball\n";
	}
}


