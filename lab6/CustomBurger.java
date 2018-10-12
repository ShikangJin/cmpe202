import java.util.* ;

public class CustomBurger {
	private String name;
	private String price;
	private List<Topping> toppings;

	public CustomBurger(String name, String price) {
		this.name = name;
		this.price = price;
		toppings = new ArrayList<>();
	}

	public void addTopping(String position, String name) {
		Topping curTopping = new Topping(position, name);
		toppings.add(curTopping);
	}

	public String getType() {
		return this.name;
	}

	public String getPrice() {
		return this.price;
	}

	public List<Topping> getToppings() {
		return this.toppings;
	}
}