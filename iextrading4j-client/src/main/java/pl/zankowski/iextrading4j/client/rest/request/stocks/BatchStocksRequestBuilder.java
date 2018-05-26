package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.BatchStocks;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

public class BatchStocksRequestBuilder extends AbstractBatchStocksRequestBuilder<BatchStocks, BatchStocksRequestBuilder> {

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
