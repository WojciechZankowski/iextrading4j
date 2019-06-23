package pl.zankowski.iextrading4j.client.sse.request.tops;

import com.google.common.collect.Sets;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.ISseRequestBuilder;

import java.io.Serializable;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public abstract class AbstractDeepSseRequestBuilder<R extends Serializable, B extends ISseRequestBuilder<R>>
        extends AbstractSymbolSseRequestBuilder<R, B> {

    private Set<DeepChannel> channels = Sets.newHashSet();

    protected String getChannels() {
        return channels.stream().map(DeepChannel::getName).collect(joining(","));
    }

    B addChannel(final DeepChannel channel) {
        this.channels.add(channel);
        return (B) this;
    }

}
