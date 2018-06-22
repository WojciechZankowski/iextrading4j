package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

import java.util.Set;

import static pl.zankowski.iextrading4j.api.util.SetUtil.immutableSet;

@JsonPropertyOrder({"symbols", "channels"})
public class DeepAsyncRequest {

    private final Set<String> symbols;
    private final Set<DeepChannel> channels;

    @JsonCreator
    public DeepAsyncRequest(
            @JsonProperty("symbols") final Set<String> symbols,
            @JsonProperty("channels") final Set<DeepChannel> channels) {
        this.symbols = immutableSet(symbols);
        this.channels = immutableSet(channels);
    }

    public Set<String> getSymbols() {
        return symbols;
    }

    public Set<DeepChannel> getChannels() {
        return channels;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DeepAsyncRequest that = (DeepAsyncRequest) o;
        return Objects.equal(symbols, that.symbols) &&
                Objects.equal(channels, that.channels);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbols, channels);
    }

    @Override
    public String toString() {
        return "DeepAsyncRequest{" +
                "symbols=" + symbols +
                ", channels=" + channels +
                '}';
    }

}
