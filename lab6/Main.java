package lab6 ;

import java.util.* ;

public class Main {
	public static void main(String[] args) {
		FrontDesk fd = new FrontDesk();
		String time = "12/1/2016  1:46:54 PM";
		String number = "45";
		CustomBurger burger = new CustomBurger("LBB", "5.59");
		burger.addTopping("top", "LETTUCE");
		burger.addTopping("top", "TOMATO");
		burger.addTopping("mid", "G ONION");
		burger.addTopping("mid", "JALA Grilled");
		burger.addTopping("bottom", "{{{{ BACON }}}}");
		fd.order(1, burger);
		fd.order(1, "LTL CAJ", "2.79");
		fd.printTicket(time, number);
	}
}