public class NoCoinState implements State {
    GumballMachine gumballMachine;
 
    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int coin) {	
		System.out.println("You inserted " + coin + " cents");
		gumballMachine.setState(gumballMachine.getHasCoinState());			
	}
 
	public void ejectCoin() {
		System.out.println("You haven't inserted any coin\n");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter\n");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first\n");
	} 
 
	public String toString() {
		return "waiting for coins\n";
	}
}
