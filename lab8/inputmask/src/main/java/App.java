/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

/**
 *  Main App Class for Displaying Screen.
 */
public class App {

    private Screen screen;
    private CreditCardNum num;
    private CreditCardExp exp;
    private CreditCardCVC cvc;
    private int count;

    public App() {

        screen = new Screen();
        num = new CreditCardNum();
        exp = new CreditCardExp(this);
        cvc = new CreditCardCVC();

        screen.addSubComponent(num);
        screen.addSubComponent(exp);
        screen.addSubComponent(cvc);

        count = 0;

    }

    public void addOneCount() {
        count++;
    }

    public String display() {
        String output = "";
        output += "========================================\n";
        output += screen.name() + "\n";
        output += "========================================\n";
        output += "\n\n\n\n";
        output += screen.display() + "\n";
        output += "\n\n\n\n";
        output += "========================================\n";
        return output;
    }

    public void key(String ch) {
        if (ch == null || ch.length() == 0) {
            return;
        }

        for (int i = 0; i < ch.length(); i++) {
            char curCh = ch.charAt(i);
            if (curCh - 48 >= 0 && curCh - 48 <= 9 && count < 23) {
                count++;
                screen.key(curCh, count);
            } else if (curCh == 'X' 
                || (i + 5 < ch.length() && ch.substring(i, i + 6).equals("Delete"))) {
                screen.key('X', count);
                count -= count == 0 ? 0 : 1;
                i += curCh == 'D' ? 5 : 0;
            }
        }
         
    }

}

