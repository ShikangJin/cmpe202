public class GumballMachineTwo implements GumballMachine {
    private int num_gumballs;
    private int quarters;

    public GumballMachineTwo( int size )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.quarters = 0;
    }

    public void insertQuarter(int coin)
    {
        if ( coin == 25 )
            this.quarters++ ;
    }
    
    public void turnCrank()
    {
        if ( this.quarters >= 2 )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                this.quarters = 0 ;
                System.out.println( "Thanks for your quarters.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your quarter." ) ;
            }
        }
        else 
        {
            if (quarters == 0) {
                System.out.println( "Please insert two quarters" ) ;
            } else {
                System.out.println( "Please insert one more quarter" ) ;
            }
            
        }        
    }
}