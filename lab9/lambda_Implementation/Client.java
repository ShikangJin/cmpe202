import java.util.function.Function;
import java.util.Arrays;
import java.util.List;

public class Client {

    @FunctionalInterface
    interface InitFunction<Handler> {
        Handler apply();
    }

    static InitFunction<Handler> init = () -> {
        Handler h1 = new Handler("R1", "Handler1") ;
        Handler h2 = new Handler("R2", "Handler2") ;
        Handler h3 = new Handler("R3", "Handler3") ;
        h1.setSuccessor.apply(h2);
        h2.setSuccessor.apply(h3);
        return h1;
    };

    public static void main( String [] args )
    {

        Handler handlerHead = init.apply();

        Function<String, Void> test = (String req) -> {
            System.out.println( "Sending " + req + "...");
            handlerHead.handleReq.apply(req);
            return null;
        } ;

    	List<String> requests = Arrays.asList(new String[]{"R2", "R3", "R1", "RX"});
        requests.forEach(req -> test.apply(req));
    }


}
