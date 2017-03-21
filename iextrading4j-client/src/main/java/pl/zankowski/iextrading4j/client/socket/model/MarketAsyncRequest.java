package pl.zankowski.iextrading4j.client.socket.model;

/**
 * @author Wojciech Zankowski
 */
public class MarketAsyncRequest extends AsyncRequest {

    public MarketAsyncRequest(String symbolList) {
        super(AsyncRequestType.MARKET, symbolList);
    }



}
