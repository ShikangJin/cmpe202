public class GumballMachineThree implements GumballMachine {
    private int num_gumballs;
    private int totalCoins;

    public GumballMachineThree( int size )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.totalCoins = 0;
    }

    public void insertQuarter(int coin)
    {
        if (coin >= 50) 
        {
            System.out.println( "You already inserted 50 cents, turn crank and get gumball." );
            return;
        }
        totalCoins += coin;
    }
    
    public void turnCrank()
    {
        if ( this.totalCoins >= 50 )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                this.totalCoins = 0 ;
                System.out.println( "Thanks for your quarter.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your quarter." ) ;
            }
        }
        else 
        {
            System.out.println( "Please insert " + (50 - totalCoins) + " cents") ;
        }        
    }
}