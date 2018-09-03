
public class Main {

	public static void main(String[] args) {
		// createGumballMachine() function accept input 0, 1, or 2 to create different types of gumball machine
		// index 0 : costs 25 cents, only accepts quarters 
		// index 1 : costs 50 cents, accepts two quarters
		// index 2 : costs 50 cents, accepts all coins
		GumballMachine gumballMachine = GumballMachineFactory.createGumballMachine(0);

		if (gumballMachine == null) {
			System.out.println("Error: invalid gumball machine type");
			return;
		}

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter( 25 );
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter( 25 );
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter( 25 );
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
