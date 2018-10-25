/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String number = "" ;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {		
		if ( number.equals("") )
			return "[4444 4444 4444 4444]" + "  " ;
		else {
			int blockNum = number.length() / 4 + (number.length() % 4 == 0 ? 0 : 1);
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			int idx = 0;
			for (int i = 0; i < blockNum; i++) {
				if (i > 0) {
					sb.append(" ");
				}
				for (int j = 0; j < 4; j++) {
					if (idx < number.length()) {
						sb.append(number.charAt(idx++));
					} else {
						break;
					}
				}
			}
			sb.append("]");
			return sb.toString() + "  ";
		}
	}	

	public void key(char ch, int cnt) {
		if ( cnt <= 16) {
			if (ch == 'X') {
				if (number.length() > 0){
					StringBuilder sb = new StringBuilder(number);
					sb.deleteCharAt(sb.length() - 1);
					number = sb.toString();
				} else {
					number = "" ;
				} 
			} else {
				StringBuilder sb = new StringBuilder(number);
				sb.append(ch) ;
				number = sb.toString();
			}
		} 
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}