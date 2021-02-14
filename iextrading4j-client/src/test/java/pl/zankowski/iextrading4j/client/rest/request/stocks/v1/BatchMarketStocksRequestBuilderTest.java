package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.v1.BatchStocks;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class BatchMarketStocksRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";
        final BatchStocksType stocksType = BatchStocksType.BOOK;

        final RestRequest<Map<String, BatchStocks>> request = new BatchMarketStocksRequestBuilder()
                .addType(stocksType)
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/batch");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, BatchStocks>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", "market"));
        assertThat(request.getQueryParams()).containsExactly(entry("types", "book"), entry("symbols", symbol));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithChartRange() {
        final String symbol = "IBM";
        final ChartRange range = ChartRange.ONE_MONTH;
        final BatchStocksType stocksType = BatchStocksType.CHART;

        final RestRequest<Map<String, BatchStocks>> request = new BatchMarketStocksRequestBuilder()
                .addType(stocksType)
                .withChartRange(range)
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/batch");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, BatchStocks>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", "market"));
        assertThat(request.getQueryParams()).contains(entry("types", "chart"), entry("symbols", symbol),
                entry("range", range.getCode()));
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithMultipleSymbols() {
        final String firstSymbol = "IBM";
        final String secondSymbol = "MSFT";
        final BatchStocksType stocksType = BatchStocksType.BOOK;

        final RestRequest<Map<String, BatchStocks>> request = new BatchMarketStocksRequestBuilder()
                .addType(stocksType)
                .withSymbols(Lists.newArrayList(firstSymbol, secondSymbol))
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/batch");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, BatchStocks>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", "market"));
        assertThat(request.getQueryParams()).containsExactly(entry("types", "book"), entry("symbols", "MSFT,IBM"));
    }

}
