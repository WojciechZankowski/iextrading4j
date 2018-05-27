package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public abstract class AbstractBatchStocksRequestBuilder<R, B extends IRestRequestBuilder<R>>
        extends AbstractChartRequestBuilder<R, B> {

    private Set<BatchStocksType> stocksTypes = new HashSet<>();

    public B withLast(final int last) {
        this.queryParameters.put("last", String.valueOf(last));
        return (B) this;
    }

    public B addType(final BatchStocksType stocksType) {
        this.stocksTypes.add(stocksType);
        return (B) this;
    }

    protected void processTypes() {
        this.queryParameters.put("types", stocksTypes.stream()
                .map(BatchStocksType::getType)
                .collect(joining(",")));
    }

}
