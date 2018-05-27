package pl.zankowski.iextrading4j.client.rest.request.stocks;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import java.util.Map;

public abstract class AbstractChartRequestBuilder<R, B extends IRestRequestBuilder<R>>
        extends AbstractStocksRequestBuilder<R, B> {

    protected final Map<String, String> queryParameters = Maps.newHashMap();

    public B withChartReset() {
        this.queryParameters.put("chartReset", Boolean.TRUE.toString());
        return (B) this;
    }

    public B withChartSimplify() {
        this.queryParameters.put("chartSimplify", Boolean.TRUE.toString());
        return (B) this;
    }

    public B withChartInterval(final Integer interval) {
        this.queryParameters.put("chartInterval", String.valueOf(interval));
        return (B) this;
    }

    public B withChangeFromClose() {
        this.queryParameters.put("changeFromClose", Boolean.TRUE.toString());
        return (B) this;
    }

    public B withChartLast(final Integer lastElements) {
        this.queryParameters.put("chartLast", String.valueOf(lastElements));
        return (B) this;
    }

    Map<String, String> getQueryParameters() {
        return queryParameters;
    }
}
