public class GumballMachineFactory {
	public static GumballMachine createGumballMachine(int type, int numberGumballs) {
		switch(type) {
			default:
				return new GumballMachineOne(numberGumballs);
			case 0:
				return new GumballMachineOne(numberGumballs);
			case 1:
				return new GumballMachineTwo(numberGumballs);
			case 2:
				return new GumballMachineThree(numberGumballs);
		}
	}
}