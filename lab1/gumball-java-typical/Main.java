
public class Main {

	public static void main(String[] args) {
		/*
			static method createGumballMachine(int type, int numberGumballs) 
			@type: accept input 0, 1, or 2 to create different types of gumball machine
				0 : machine that costs 25 cents, only accepts quarters 
				1 : machine that costs 50 cents, accepts two quarters
				2 : machine that costs 50 cents, accepts all coins
				default machine: 0
			@numberGumballs: the initial gumballs in machine
		*/

		GumballMachine gumballMachine = GumballMachineFactory.createGumballMachine(2, 5);

		if (gumballMachine == null) {
			System.out.println("Error: invalid gumball machine type");
			return;
		}

		// test case
		System.out.println(gumballMachine);

		gumballMachine.insertCoin(10);
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(10);
		gumballMachine.insertCoin(10);
		gumballMachine.insertCoin(10);
		gumballMachine.insertCoin(10);
		gumballMachine.turnCrank();
		gumballMachine.insertCoin(25);

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(25);
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
