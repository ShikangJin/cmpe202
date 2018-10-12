import java.util.* ;

public class FrontDesk {

	List<Ticket> list;
	Ticket receipt;
	Ticket slip;


	public FrontDesk(){
		list = new ArrayList<>();
		receipt = new Receipt();
		slip = new Slip();
		list.add(receipt);
		list.add(slip);
	}

	public void order(int number, CustomBurger burger) {
		for (Ticket ticket : list) {
			ticket.add(number, burger);
		}
	}

	public void order(int number, String item, String price) {
		for (Ticket ticket : list) {
			ticket.add(number, item, price);
		}
	}

	public void printTicket(String time, String number) {
		for (Ticket ticket : list) {
			ticket.print(time, number);
			System.out.println("\n\n");
		}
	}

}