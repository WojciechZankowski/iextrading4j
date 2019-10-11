package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.v1.Split;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicator;
import pl.zankowski.iextrading4j.api.stocks.v1.TechnicalIndicatorType;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.SplitsRange;

import javax.ws.rs.core.GenericType;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class TechnicalIndicatorRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final RestRequest<TechnicalIndicator> request = new TechnicalIndicatorRequestBuilder()
                .withSymbol(symbol)
                .withTechnicalIndicatorType(TechnicalIndicatorType.ACOS)
                .withRange(ChartRange.ONE_MONTH)
                .withInput1(BigDecimal.ONE)
                .withInput2(BigDecimal.TEN)
                .withInput3(BigDecimal.ZERO)
                .withInput4(BigDecimal.valueOf(2))
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/indicator/{indicator}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<TechnicalIndicator>() {
        });
        assertThat(request.getPathParams()).contains(
                entry("symbol", symbol),
                entry("indicator", "acos"));
        assertThat(request.getQueryParams()).contains(
                entry("range", ChartRange.ONE_MONTH.getCode()),
                entry("input1", "1"),
                entry("input2", "10"),
                entry("input3", "0"),
                entry("input4", "2"));
    }

}
