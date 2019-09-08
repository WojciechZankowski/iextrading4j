package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.v1.BatchStocks;
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
