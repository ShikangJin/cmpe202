
public class GumballMachine {
 
	State soldOutState;
	State noCoinState;
	State hasCoinState;
	State soldState;
 
	State state = soldOutState;
	private int count = 0, totalCoin = 0, cost;
	private boolean quarterReq;
 	

 	/*
		@type: input an index to choose a gumball machine to create
				0: create gumball machine costs 25 cents and takes quarter only
				1: create gumball machine costs 50 cents and takes quarters only
				2: create gumball machine costs 50 cents and takes any coin
		@numberGumballs: input the initial amount of gumballs in machine
 	*/
	public GumballMachine(int type, int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noCoinState = new NoCoinState(this);
		hasCoinState = new HasCoinState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noCoinState;
		} 

		switch(type) {
			case 0:
				cost = 25;
				quarterReq = true;
				break;
			case 1:
				cost = 50;
				quarterReq = true;
				break;
			case 2:
				cost = 50;
				quarterReq = false;
				break;
		}
	}


 	/*
		insert a coin into machine
		@coin: the value of coin. eg: 1, 10, 25
 	*/
	public void insertCoin(int coin) {
		if (quarterReq && coin != 25) {
			System.out.println("You must insert quarter\n");
			return;
		}
		state.insertCoin(coin);
		if (state == hasCoinState && totalCoin < cost) {
			totalCoin += coin;
			System.out.println(totalCoin + " cent(s) in machine now\n");
		}
	}

	/*
		eject all rest coin from machine
	*/
	public void ejectCoin() {
		state.ejectCoin();
		if (state == noCoinState) {
			totalCoin = 0;
		}
	}

	/*
		turn the crank to get gumball
	*/
	public void turnCrank() {
		state.turnCrank();
		if (state == soldState) {
			totalCoin -= cost;
		}
		state.dispense();
	}

	/*
		set current state of machine
		@state: the state that will be set to machine
	*/
	void setState(State state) {
		this.state = state;
	}
 	
 	/*
		release a gumball
 	*/
 	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		System.out.println(this.totalCoin + " cent(s) in machine now\n");
		if (count != 0) {
			count = count - 1;
		}
	}
 	
 	/*
		return the amount of gumball in current machine
 	*/
	int getCount() {
		return count;
	}

	/*
		return the amount of coin in current machine
	*/
  	int getCoin() {
 		return totalCoin;
 	}
 	
 	/*
		refill current machine with gumballs
		@count: the amount of gumball that used to refill 
 	*/
	void refill(int count) {
		this.count = count;
		state = noCoinState;
	}

	/*
		return the cost of current machine
	*/
	int getCost() {
		return cost;
	}

	/*
		return current state of current machine
	*/
	State getState() {
        return state;
    }

    /*
		return the soldOutState of current machine
    */
    State getSoldOutState() {
        return soldOutState;
    }

    /*
		return the noCoinState of current machine
    */
    State getNoCoinState() {
        return noCoinState;
    }

    /*
		return the hasCoinState of current machine
    */
    State getHasCoinState() {
        return hasCoinState;
    }

    /*
		return the soldState of current machine
    */
    State getSoldState() {
        return soldState;
    }

    /*
		print information of current machine
    */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
