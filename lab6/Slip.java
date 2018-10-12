package lab6 ;

import java.util.* ;

public class Slip implements Ticket {

	String order;
	private int maxText = 40;

	public Slip() {
		order = "";
	}

	@Override
	public void add(int number, CustomBurger burger) {
		order += Integer.toString(number) + "  " + burger.getType();
		String top = "";
		String mid = "";
		String bottom = "";
		List<Topping> toppings = burger.getToppings();
		for (Topping topping : toppings) {
			if (topping.position.equals("top")) {
				top += topping.name;
				top += "\n";
			} else if (topping.position.equals("mid")) {
				mid += ("->|" + topping.name);
				mid += "\n";
			} else if (topping.position.equals("bottom")) {
				bottom += topping.name;
				bottom += "\n"; 
			}
		}
		order += (top + mid + bottom);
	}

	@Override
	public void add(int number, String item, String price) {
		order += Integer.toString(number) + " " + item + "\n";
	}

	@Override
	public void print(String time, String number) {
		System.out.println(this.getClass());
		System.out.println("========================================\n");
		System.out.println("Order Number: " + number);
		System.out.println(center(maxText, time));
		System.out.println(center(maxText, "FIVE GUYS"));
		System.out.println("Sandwich# 1");
		System.out.print(order);
	}

	private String center(int maxText,  String str) {
		int padding = maxText - str.length();
		String res = "";
		for (int i = 0; i < padding / 2; i++) {
			res += " ";
		}
		res += str;
		return res;
	}
}