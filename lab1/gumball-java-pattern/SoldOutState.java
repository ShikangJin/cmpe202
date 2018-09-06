

public class SoldOutState implements State {
    GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int coin) {
		System.out.println("You can't insert a coin, the machine is sold out\n");
	}
 
	public void ejectCoin() {
		System.out.println("You can't eject, you haven't inserted a coin yet\n");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs\n");
	}
 
	public void dispense() {
		System.out.println("No gumball dispensed\n");
	}
 
	public String toString() {
		return "sold out\n";
	}
}
