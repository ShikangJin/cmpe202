

public class BuildOrder {

    private static CustomBurger customBurger;
    private static Burger b;
    private static Cheese c;
    private static PremiumCheese pc;
    private static Sauce s;
    private static UnlimitedToppings ut;
    private static PremiumToppings pt;
    private static Bun bun;
    private static Side side;

    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;

        /************************ Burger One ************************/
        customBurger = new CustomBurger( "Build Your Own Burger" ) ;
        
        // Organic Bison* + 1/2lb. + On A Bun
        b = new Burger( "Burger Options" ) ;
        String[] bo = { "Organic Bison*", "1/2lb.", "On A Bun" } ;
        b.setOptions( bo ) ;
        
        // Spicy Jalapeno Jack + Yellow American
        c = new Cheese( "Cheese Options" ) ;
        String[] co = { "Yellow American", "Spicy Jalapeno Jack" } ;
        c.setOptions( co ) ;
        c.wrapDecorator( b ) ;

        // Danish Blue Cheese
        pc = new PremiumCheese( "PremiumCheese Options" );
        String[] pco = { "Danish Blue Cheese" };
        pc.setOptions(pco);
        pc.wrapDecorator( c );

        // Mayonnaise + Thai Peanut Sauce
        s = new Sauce( "Sauce Options" ) ;
        String[] so = { "Mayonnaise", "Thai Peanut Sauce" } ;
        s.setOptions( so ) ;
        s.wrapDecorator( pc ) ;

        // Black Olives + Dill Pickle Chips + Spicy Pickles
        ut = new UnlimitedToppings( "UnlimitedToppings Options" );
        String[] uto = { "Black Olives", "Dill Pickle Chips", "Spicy Pickles" };
        ut.setOptions( uto );
        ut.wrapDecorator( s );

        // Marinated Tomatoes
        pt = new PremiumToppings( "PremiumToppings Options" );
        String[] pto = { "Marinated Tomatoes" };
        pt.setOptions( pto );
        pt.wrapDecorator( ut );

        // Ciabatta(Vegan)
        bun = new Bun( "Bun Option " );
        String[] buno = { "Ciabatta(Vegan)" };
        bun.setOptions( buno );
        bun.wrapDecorator( pt );

        // Shoestring Fries
        side = new Side( "Side Option" );
        String[] sideo = { "Shoestring Fries" };
        side.setOptions( sideo );
        side.wrapDecorator( bun );
        
        // Setup Custom Burger Ingredients
        customBurger.setDecorator( side ) ;
        buildBurger(order);


        /************************ Burger Two ************************/
        customBurger = new CustomBurger( "Build Your Own Burger" ) ;
        
        // Hormone & Antibiotic Free Beef* + 1/3lb. + On A Bun
        b = new Burger( "Burger Options" ) ;
        String[] bo2 = { "Hormone & Antibiotic Free Beef*", "1/3lb.", "On A Bun" } ;
        b.setOptions( bo2 ) ;
        
        // Greek Feta + Smoked Gouda
        c = new Cheese( "Cheese Options" ) ;
        String[] co2 = { "Greek Feta", "Smoked Gouda" } ;
        c.setOptions( co2 ) ;
        c.wrapDecorator( b ) ;

        // Fresh Mozzarella
        pc = new PremiumCheese( "PremiumCheese Options" );
        String[] pco2 = { "Fresh Mozzarella" };
        pc.setOptions(pco2);
        pc.wrapDecorator( c );

        // Habanero Salsa
        s = new Sauce( "Sauce Options" ) ;
        String[] so2 = { "Habanero Salsa" } ;
        s.setOptions( so2 ) ;
        s.wrapDecorator( pc ) ;

        // Crushed Peanuts
        ut = new UnlimitedToppings( "UnlimitedToppings Options" );
        String[] uto2 = { "Crushed Peanuts" };
        ut.setOptions( uto2 );
        ut.wrapDecorator( s );

        // Marinated Tomatoes + Sunny Side Up Egg*
        pt = new PremiumToppings( "PremiumToppings Options" );
        String[] pto2 = { "Marinated Tomatoes", "Sunny Side Up Egg*" };
        pt.setOptions( pto2 );
        pt.wrapDecorator( ut );

        // Gluten-Free Bun
        bun = new Bun( "Bun Option " );
        String[] buno2 = { "Gluten-Free Bun" };
        bun.setOptions( buno2 );
        bun.wrapDecorator( pt );

        // Shoestring Fries
        side = new Side( "Side Option" );
        String[] sideo2 = { "Shoestring Fries" };
        side.setOptions( sideo2 );
        side.wrapDecorator( bun );
        
        // Setup Custom Burger Ingredients
        customBurger.setDecorator( side ) ;
        buildBurger(order);
        
        return order ;
    }

    private static void buildBurger(Composite order) {
        if (customBurger == null) 
            return;
        customBurger.addChild( b ) ;
        customBurger.addChild( c ) ;
        customBurger.addChild( pc ) ;
        customBurger.addChild( s ) ;
        customBurger.addChild( ut ) ;
        customBurger.addChild( pt ) ;
        customBurger.addChild( bun ) ;
        customBurger.addChild( side ) ;
        if (order != null) 
            order.addChild(customBurger);
        
    }

}


/*

Counter Burger Menu:
https://thecounterburger.emn8.com/?store=Times%20Square

*/