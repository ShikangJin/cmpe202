package lab6 ;

public interface Ticket {
	
	public void add(int number, CustomBurger burger);

	public void add(int number, String item, String price);

	public void print(String time, String number);
}