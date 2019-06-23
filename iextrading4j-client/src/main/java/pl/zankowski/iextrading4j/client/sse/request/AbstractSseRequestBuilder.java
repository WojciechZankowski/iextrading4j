package pl.zankowski.iextrading4j.client.sse.request;

import java.io.Serializable;

public abstract class AbstractSseRequestBuilder<R extends Serializable, B extends ISseRequestBuilder<R>>
        implements ISseRequestBuilder<R> {

    private boolean noSnapshot;

    B withNoSnapshot() {
        this.noSnapshot = true;
        return (B) this;
    }

}
