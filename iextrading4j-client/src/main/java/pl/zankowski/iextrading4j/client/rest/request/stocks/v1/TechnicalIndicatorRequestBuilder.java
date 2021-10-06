package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicator;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicatorType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.math.BigDecimal;
import java.util.Map;

public class TechnicalIndicatorRequestBuilder extends AbstractStocksRequestBuilder<TechnicalIndicator,
        TechnicalIndicatorRequestBuilder> implements IEXCloudV1RestRequest<TechnicalIndicator> {

    private static final String RANGE_PARAM_NAME = "range";
    private static final String INPUT_1_NAME = "input1";
    private static final String INPUT_2_NAME = "input2";
    private static final String INPUT_3_NAME = "input3";
    private static final String INPUT_4_NAME = "input4";
    private static final String TECHNICAL_INDICATOR_TYPE_NAME = "indicator";

    private final Map<String, String> queryParameters = Maps.newHashMap();
    private TechnicalIndicatorType indicatorType;

    public TechnicalIndicatorRequestBuilder withTechnicalIndicatorType(final TechnicalIndicatorType indicatorType) {
        this.indicatorType = indicatorType;
        return this;
    }

    public TechnicalIndicatorRequestBuilder withInput1(final BigDecimal input1) {
        this.queryParameters.put(INPUT_1_NAME, input1.toPlainString());
        return this;
    }

    public TechnicalIndicatorRequestBuilder withInput2(final BigDecimal input2) {
        this.queryParameters.put(INPUT_2_NAME, input2.toPlainString());
        return this;
    }

    public TechnicalIndicatorRequestBuilder withInput3(final BigDecimal input3) {
        this.queryParameters.put(INPUT_3_NAME, input3.toPlainString());
        return this;
    }

    public TechnicalIndicatorRequestBuilder withInput4(final BigDecimal input4) {
        this.queryParameters.put(INPUT_4_NAME, input4.toPlainString());
        return this;
    }

    public TechnicalIndicatorRequestBuilder withRange(final ChartRange chartRange) {
        queryParameters.put(RANGE_PARAM_NAME, chartRange.getCode());
        return this;
    }

    @Override
    public RestRequest<TechnicalIndicator> build() {
        return RestRequestBuilder.<TechnicalIndicator>builder()
                .withPath("/stock/{symbol}/indicator/{indicator}")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                .addPathParam(TECHNICAL_INDICATOR_TYPE_NAME, indicatorType.name().toLowerCase()).get()
                .withResponse(new GenericType<TechnicalIndicator>() {})
                .addQueryParam(queryParameters)
                .build();
    }

}
