/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardCVC implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String cvc = "" ;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( cvc.equals("") )
			return "[123]" + "  " ;
		else
			return "[" + cvc + "]" + "  " ;
	}	

	public void key(char ch, int cnt) {
		if (cnt < 21) return;

		if ( cnt >= 21 && cnt <= 23 ) {
			if (ch == 'X') {
				if (cvc.length() > 0){
					StringBuilder sb = new StringBuilder(cvc);
					sb.deleteCharAt(sb.length() - 1);
					cvc = sb.toString();	
				} else {
					cvc = "" ;
				} 
			} else {
				StringBuilder sb = new StringBuilder(cvc);
				sb.append(ch) ;
				cvc = sb.toString();
			}
		}
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;		
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}