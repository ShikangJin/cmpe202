public class GumballMachineTwo implements GumballMachine {
    private int num_gumballs;
    private int quarters;

    public GumballMachineTwo( int size ) {
        // initialise instance variables
        num_gumballs = size;
        quarters = 0;
    }

    public void insertCoin(int coin) {
        if ( coin == 25 ) {
            if (quarters == 2) {
                System.out.println( "You already inserted 50 cents, turn crank and get gumball.\n" );
                return;
            }
            quarters++ ;
            System.out.println( "You insert 25 cents." );
            System.out.println( 25 * quarters + " in machine now.\n" );
        } else {
            System.out.println( "Accept quarter only.\n" );
        }

    }
    
    public void turnCrank() {
        if ( quarters == 2 ) {
            if ( num_gumballs > 0 ) {
                num_gumballs-- ;
                quarters = 0 ;
                System.out.println( "Thanks for your quarters.  Gumball Ejected!" ) ;
                System.out.println( 25 * quarters + " in machine now.\n" );
            }
            else {
                System.out.println( "No More Gumballs!  Sorry, can't return your quarter.\n" ) ;
            }
        }
        else {
            if ( quarters == 0 ) {
                System.out.println( "Please insert two quarters.\n" ) ;
            } else {
                System.out.println( "Please insert one more quarter.\n" ) ;
            }
            
        }        
    }
}