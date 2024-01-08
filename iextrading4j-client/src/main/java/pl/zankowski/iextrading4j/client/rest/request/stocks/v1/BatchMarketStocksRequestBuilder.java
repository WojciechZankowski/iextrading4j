package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import com.google.common.collect.Sets;
import pl.zankowski.iextrading4j.api.stocks.v1.BatchStocks;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class BatchMarketStocksRequestBuilder extends AbstractBatchStocksRequestBuilder<Map<String, BatchStocks>,
        BatchMarketStocksRequestBuilder> {

    private Set<String> symbols = Sets.newHashSet();

    @Override
    public BatchMarketStocksRequestBuilder withSymbol(final String symbol) {
        this.symbols.add(symbol);
        return this;
    }

    public BatchMarketStocksRequestBuilder withSymbols(final List<String> symbols) {
        this.symbols.addAll(symbols);
        return this;
    }

    protected void processSymbols() {
        this.queryParameters.put("symbols", symbols.stream()
                .collect(joining(",")));
    }

    @Override
    public RestRequest<Map<String, BatchStocks>> build() {
        processTypes();
        processSymbols();
        return RestRequestBuilder.<Map<String, BatchStocks>>builder()
                .withPath("/stock/{symbol}/batch")
                .addPathParam("symbol", "market").get()
                .withResponse(new GenericType<Map<String, BatchStocks>>() {
                })
                .addQueryParam(getQueryParameters())
                .build();
    }

}
