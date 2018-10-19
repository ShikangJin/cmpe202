public class PremiumToppings extends LeafDecorator
{
    private String[] options ;
    
    
    public PremiumToppings( String d )
    {
        super(d) ;
    }
    
    // +$1.00 ~ $3.00 per selection
    public void setOptions( String[] options )
    {
        this.options = options ;
        this.price += options.length * 1.00 ;
        for ( int i = 0; i<options.length; i++ ) {
            if ( "Marinated Tomatoes".equals(options[i]) ) this.price += 2.00 ;
        }
    }
    
    public String getDescription() 
    {
        String desc = "" ;
        for ( int i = 0; i<options.length; i++ )
        {
            if (i>0) desc += " + " + options[i] ;
            else desc = options[i] ;
        }        
        return desc ;
    }
    
}