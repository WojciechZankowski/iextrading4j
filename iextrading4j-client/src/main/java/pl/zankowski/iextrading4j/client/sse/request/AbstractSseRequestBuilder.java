package pl.zankowski.iextrading4j.client.sse.request;

import java.io.Serializable;

public abstract class AbstractSseRequestBuilder<R extends Serializable, B extends ISseRequestBuilder<R>>
        implements ISseRequestBuilder<R> {

    protected static final String NO_SNAPSHOT_PARAM = "nosnapshot";

    private boolean noSnapshot;

    protected String isNoSnapshot() {
        return String.valueOf(noSnapshot);
    }

    B withNoSnapshot() {
        this.noSnapshot = true;
        return (B) this;
    }

}
