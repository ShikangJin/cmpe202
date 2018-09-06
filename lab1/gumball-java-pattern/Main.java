public class Main {

	public static void main(String[] args) {
		/* 
			Use GumballMachine class to create different types of gumball machine
			GumballMachine(int type, int numberGumballs)
			Please read GumballMachineFactory class for more detail 
		*/
		GumballMachine gumballMachine = new GumballMachine(2, 5);

		// test case
		System.out.println(gumballMachine);

		gumballMachine.insertCoin(10);
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();
		gumballMachine.ejectCoin();

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
