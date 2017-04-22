package pl.zankowski.iextrading4j.client.socket.model;

/**
 * @author Wojciech Zankowski
 */
public abstract class AsyncRequest {

    private AsyncRequestType asyncRequestType;

    public AsyncRequest(AsyncRequestType asyncRequestType) {
        this.asyncRequestType = asyncRequestType;
    }

    public AsyncRequestType getAsyncRequestType() {
        return asyncRequestType;
    }

}
