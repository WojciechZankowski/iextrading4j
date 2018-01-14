package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.IAsyncRequest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class LastAsyncRequestBuilder implements IAsyncRequest<LastTrade> {

    private Set<String> symbols = new HashSet<>();

    public LastAsyncRequestBuilder withSymbol(String symbol) {
        this.symbols.add(symbol);
        return this;
    }

    public LastAsyncRequestBuilder withSymbols(String... symbols) {
        this.symbols.addAll(Arrays.asList(symbols));
        return this;
    }

    public LastAsyncRequestBuilder withAllSymbols() {
        this.symbols.clear();
        this.symbols.add("firehose");
        return this;
    }

    @Override
    public SocketRequest<LastTrade> build() {
        return SocketRequestBuilder.<LastTrade>builder()
                .withPath("/last")
                .withResponse(LastTrade.class)
                .addParam(symbols.stream().collect(joining(",")))
                .build();
    }
}
