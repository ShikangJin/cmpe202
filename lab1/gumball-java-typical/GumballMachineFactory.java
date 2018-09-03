public class GumballMachineFactory {
	public static GumballMachine createGumballMachine(int type) {
		switch(type) {
			case 0:
				return new GumballMachineOne(5);
			case 1:
				return new GumballMachineTwo(5);
			case 2:
				return new GumballMachineThree(5);
		}
		return null;
	}
}