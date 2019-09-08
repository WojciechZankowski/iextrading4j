package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractChartRequestBuilder;

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

    public B withPeriod(final Period period) {
        this.queryParameters.put("period", period.name().toLowerCase());
        return (B) this;
    }

    public B withChartRange(final ChartRange chartRange) {
        this.queryParameters.put("range", chartRange.getCode());
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
