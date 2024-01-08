package pl.zankowski.iextrading4j.client.rest.request.datapoint;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.datapoint.DataPoint;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class DataPointsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateDataPointsRequest() {
        final String symbol = "AAPL";

        final RestRequest<List<DataPoint>> request = new DataPointsRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/data-points/{symbol}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<DataPoint>>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol));
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    void shouldSuccessfullyCreateKeyDataPointRequest() {
        final String symbol = "AAPL";
        final String key = "PRICE-TARGET";

        final RestRequest<String> request = new DataPointsRequestBuilder()
                .withSymbol(symbol)
                .withKey(key)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/data-points/{symbol}/{key}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<String>() {
        });
        assertThat(request.getPathParams()).containsExactly(entry("symbol", symbol), entry("key", key));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
