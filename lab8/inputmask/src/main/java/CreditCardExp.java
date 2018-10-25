/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */
import java.util.*;

public class CreditCardExp implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String month = "", year = "";
	private App app;

	public CreditCardExp(App app) {
		this.app = app;
	}

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( month.equals("") && year.equals("") )
			return "[MM/YY]" + "  " ;
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append(month);
			if (!year.equals("")) {
				sb.append("/");
				sb.append(year);
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
				yearHandler(ch, cnt);
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
		if (year.length() > 0) {
			sb = new StringBuilder(year);
			sb.deleteCharAt(sb.length() - 1);
			year = sb.toString();
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

	private void yearHandler(char ch, int cnt) {
		StringBuilder sb = new StringBuilder(year);	
		sb.append(ch);
		year = sb.toString();
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