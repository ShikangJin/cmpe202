import java.util.* ;

public class Receipt implements Ticket {

	String order;
	private int maxText = 40;
	float totalPrice;

	public Receipt() {
		order = "";
		totalPrice = 0;
	}

	@Override
	public void add(int number, CustomBurger burger) {
		String price = burger.getPrice();
		String description = Integer.toString(number) + "  " + burger.getType();
		order += twoSide(description, price, maxText);
		order += "\n";
		List<Topping> toppings = burger.getToppings();
		for (Topping topping : toppings) {
			String curTopping = "";
			if (topping.position.equals("mid")) {
				curTopping += "->|";
			}
			curTopping += topping.name;
			order += (" " + curTopping + "\n");
		}
		totalPrice += Float.parseFloat(price); 
	}

	@Override
	public void add(int number, String item, String price) {
		String description = Integer.toString(number) + " " + item;
		order += twoSide(description, price, maxText);
		order += "\n"; 
		totalPrice += Float.parseFloat(price); 
	}

	@Override
	public void print(String time, String number) {
		System.out.println(center(maxText, this.getClass().getName()));
		System.out.println("========================================\n");
		System.out.println(center(maxText, "FIVE GUYS"));
		System.out.println(center(maxText, "BURGERS AND FRIES"));
		System.out.println(center(maxText, "STORE # CA-1294"));
		System.out.println(center(maxText, "5353 ALMADEN EXPY N60"));
		System.out.println(center(maxText, "SAN JOSE, CA 95118"));
		System.out.println(center(maxText, "(P) 408-264-9300"));
		System.out.println("\n");
		System.out.println(center(maxText, time));
		System.out.println(center(maxText, "FIVE GUYS"));
		System.out.println("Order Number: " + number);
		System.out.println(order);
		System.out.println("\n");
		String left = "Sub. Total:";
		String right = "$" + totalPrice;
		System.out.println(twoSide(left, right, maxText));
	}

	private String twoSide(String left, String right, int maxText) {
		String res = "";
		int padding = maxText - left.length() - right.length();
		res += left;
		for (int i = 0; i < padding; i++) {
			res += " ";
		}
		res += right;
		return res;
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