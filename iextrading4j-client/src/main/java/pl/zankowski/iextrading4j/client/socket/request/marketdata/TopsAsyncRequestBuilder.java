package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.IAsyncRequest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class TopsAsyncRequestBuilder implements IAsyncRequest<TOPS> {

    private Set<String> symbols = new HashSet<>();

    public TopsAsyncRequestBuilder withSymbol(String symbol) {
        this.symbols.add(symbol);
        return this;
    }

    public TopsAsyncRequestBuilder withSymbols(String... symbols) {
        this.symbols.addAll(Arrays.asList(symbols));
        return this;
    }

    public TopsAsyncRequestBuilder withAllSymbols() {
        this.symbols.clear();
        this.symbols.add("firehose");
        return this;
    }

    @Override
    public SocketRequest<TOPS> build() {
        return SocketRequestBuilder.<TOPS>builder()
                .withPath("/last")
                .withResponse(TOPS.class)
                .addParam(symbols.stream().collect(joining(",")))
                .build();
    }
}
