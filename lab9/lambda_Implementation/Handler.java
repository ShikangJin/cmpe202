import java.util.function.Function;

public class Handler {
    Handler successor = null;
    private String type = "";
    private String name="";

    public Handler(String type, String name) {
        this.type = type;
        this.name = name;
    }

    Function<Handler, Void> setSuccessor = (Handler next) -> {
        this.successor = next;
        return null;
    };

    Function<String, Void> handleReq = (String req) -> {
        Runnable receiveRequest = () -> System.out.println( this.name +  " got the request...");
        Runnable doRequest = () -> System.out.println( this.name + " => This one is mine!");
        receiveRequest.run();
        if ( req.equalsIgnoreCase(this.type) )
            doRequest.run();
        else if ( this.successor != null )
            this.successor.handleReq.apply(req);
        return null;
    };

}

