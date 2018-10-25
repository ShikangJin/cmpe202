/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */
import java.util.*;

public class CreditCardExp implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String month = "", date = "";
	private App app;
	private Set<String> largeMonthes, smallMonthes;

	public CreditCardExp(App app) {
		this.app = app;
		largeMonthes = new HashSet<>(Arrays.asList("01", "03", "05", "07", "08", "10", "12"));
		smallMonthes = new HashSet<>(Arrays.asList("04", "06", "09", "11"));
	}

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( month.equals("") && date.equals("") )
			return "[MM/YY]" + "  " ;
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append(month);
			if (!date.equals("")) {
				sb.append("/");
				sb.append(date);
			}
			sb.append("]");
			return sb.toString() + "  " ;
		}
	}	

	public void key(char ch, int cnt) {
		if ( cnt >= 17 && cnt <= 20  ) {
			if (ch == 'X') {
				deleteHandler();
			} else if (month.length() < 2) {
				monthHandler(ch, cnt);
			} else {
				dateHandler(ch, cnt);
			}
		}
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

	private void deleteHandler() {
		StringBuilder sb;
		if (date.length() > 0) {
			sb = new StringBuilder(date);
			sb.deleteCharAt(sb.length() - 1);
			date = sb.toString();
		} else if (month.length() > 0) {
			sb = new StringBuilder(month);
			sb.deleteCharAt(sb.length() - 1);
			month = sb.toString();
		} else {
			month = "";
		}
	}

	private void monthHandler(char ch, int cnt) {
		StringBuilder sb = new StringBuilder(month);
		int curNum = ch - 48;
		if (sb.length() == 0) {
			if (curNum > 1) {
				app.addOneCount();
				sb.append('0');	
			} 
			sb.append(ch);
		} else if (curNum <= 2) {
			sb.append(ch);	
		} else {
			autoComplete(sb);
			key(ch, cnt + 1);
		}
		month = sb.toString();
	}

	private void dateHandler(char ch, int cnt) {
		StringBuilder sb = new StringBuilder(date);
		int curNum = ch - 48;
		if (date.length() == 0) {
			if ((month.equals("02") && curNum > 2) || curNum > 3 ) {
				app.addOneCount();
				sb.append('0');
			} 
			sb.append(ch);		
		} else if (sb.charAt(sb.length() - 1) - 48 < 3) {
			sb.append(ch);
		} else {
			if ((curNum > 1 && largeMonthes.contains(month)) 
				|| (curNum > 0 && smallMonthes.contains(month))) {
				autoComplete(sb);
				nextHandler.key(ch, cnt + 1);
			} else {
				sb.append(ch);
			}
		}
		date = sb.toString();
	}

	private void autoComplete(StringBuilder sb) {
		if (sb.length() == 0) {
			return;
		}
		char lastCh = sb.charAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
		sb.append('0');
		sb.append(lastCh);
		app.addOneCount();
	}

}