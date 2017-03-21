package pl.zankowski.iextrading4j.client.socket.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
