package pl.zankowski.iextrading4j.client.socket.model;

/**
 * @author Wojciech Zankowski
 */
public class TOPSAsyncRequest extends AsyncRequest {

    public TOPSAsyncRequest(String symbolList) {
        super(AsyncRequestType.TOPS, symbolList);
    }
}
