package pl.zankowski.iextrading4j.client.rest.request.stocks.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.BatchStocks;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class BatchStocksRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";
        final BatchStocksType stocksType = BatchStocksType.NEWS;

        final RestRequest<BatchStocks> request = new BatchStocksRequestBuilder()
                .addType(stocksType)
                .withSymbol(symbol)
                .withLast(5)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/batch");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<BatchStocks>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).contains(entry("types", "news"), entry("last", "5"));
    }

}
