public class GumballMachineThree implements GumballMachine {
    private int num_gumballs;
    private int totalCoins;

    public GumballMachineThree( int size ) {
        // initialise instance variables
        num_gumballs = size;
        totalCoins = 0;
    }

    public void insertCoin(int coin) {
        if (totalCoins >= 50) {
            System.out.println( "You already inserted 50 cents, turn crank and get gumball." );
            return;
        }
        totalCoins += coin;
        System.out.println( "You insert " + coin + " cents." );
        System.out.println( totalCoins + " in machine now.\n" );
    }
    
    public void turnCrank() {
        if ( totalCoins >= 50 ) {
            if ( num_gumballs > 0 ) {
                num_gumballs-- ;
                totalCoins -= 50 ;
                System.out.println( "Thanks for your quarter.  Gumball Ejected!" ) ;
                System.out.println( totalCoins + " in machine now.\n" );
            }
            else {
                System.out.println( "No More Gumballs!  Sorry, can't return your quarter.\n" ) ;
            }
        }
        else {
            System.out.println( "Still need " + (50 - totalCoins) + " cents for a gumball\n") ;
        }        
    }
}