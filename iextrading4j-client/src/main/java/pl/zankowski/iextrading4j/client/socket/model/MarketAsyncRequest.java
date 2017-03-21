package pl.zankowski.iextrading4j.client.socket.model;

/**
 * @author Wojciech Zankowski
 */
public class MarketAsyncRequest extends AsyncRequest {

    public MarketAsyncRequest() {
        super(AsyncRequestType.MARKET);
    }

    public static MarketAsyncRequest.Builder builder() {
        return new MarketAsyncRequest.Builder();
    }

    public static class Builder {

        public MarketAsyncRequest build() {
            return new MarketAsyncRequest();
        }

    }

}
