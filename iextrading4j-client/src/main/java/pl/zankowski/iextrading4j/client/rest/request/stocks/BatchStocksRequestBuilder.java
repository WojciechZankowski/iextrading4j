package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.BatchStocks;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class BatchStocksRequestBuilder extends AbstractChartRequestBuilder<BatchStocks, BatchStocksRequestBuilder> {

    private Set<BatchStocksType> stocksTypes = new HashSet<>();


    public BatchStocksRequestBuilder withLast(int last) {
        this.queryParameters.put("last", String.valueOf(last));
        return this;
    }

    public BatchStocksRequestBuilder addType(final BatchStocksType stocksType) {
        this.stocksTypes.add(stocksType);
        return this;
    }

    protected void processTypes() {
        this.queryParameters.put("types", stocksTypes.stream()
                .map(BatchStocksType::getType)
                .collect(joining(",")));
    }

    @Override
    public RestRequest<BatchStocks> build() {
        processTypes();
        return RestRequestBuilder.<BatchStocks>builder()
                .withPath("/stock/{symbol}/batch")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(BatchStocks.class)
                .addQueryParam(getQueryParameters())
                .build();
    }
}
