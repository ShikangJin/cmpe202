public interface State {
 	
 	/*
		try to insert coin in current state
		@coin: the amount of inserted coin
 	*/
	public void insertCoin(int coin);

	/*
		try to eject coin in current state
	*/
	public void ejectCoin();

	/*
		try to turn crank in current state
	*/
	public void turnCrank();

	/*
		try to dispense gumball in current state
	*/
	public void dispense();
}
