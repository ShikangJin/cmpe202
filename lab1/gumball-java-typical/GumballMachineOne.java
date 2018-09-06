public class GumballMachineOne implements GumballMachine {
    private int num_gumballs;
    private boolean has_quarter;

    public GumballMachineOne( int size ) {
        // initialise instance variables
        num_gumballs = size;
        has_quarter = false;
    }

    public void insertCoin(int coin) {
        if ( coin == 25 ) {
            if (has_quarter) {
                System.out.println( "You already insert 25 cents, turn crank and get gumball.\n" );
                return;
            } 
            System.out.println( "You insert 25 cents.\n" );
            has_quarter = true ;
        }  
        else {
            System.out.println( "Accept quarter only.\n" );
        }
    }
    
    public void turnCrank() {
        if ( has_quarter ) {
            if ( num_gumballs > 0 ) {
                num_gumballs-- ;
                has_quarter = false ;
                System.out.println( "Thanks for your quarter.  Gumball Ejected!\n" ) ;
            }
            else {
                System.out.println( "No More Gumballs!  Sorry, can't return your quarter.\n" ) ;
            }
        }
        else {
            System.out.println( "Please insert a quarter.\n" ) ;
        }        
    }
}