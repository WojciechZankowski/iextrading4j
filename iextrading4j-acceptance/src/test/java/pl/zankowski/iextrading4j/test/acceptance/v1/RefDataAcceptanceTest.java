package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.v1.HolidayAndTradingDate;
import pl.zankowski.iextrading4j.api.refdata.v1.Symbol;
import pl.zankowski.iextrading4j.api.refdata.v1.UsExchange;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.DateDirection;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.DateType;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.ExchangeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.ExchangeSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.IEXSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.RegionSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.UsExchangeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.UsHolidayAndTradingDateRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefDataAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    public void symbolsTest() {
        final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new SymbolsRequestBuilder()
                .build());
        assertThat(symbols).isNotNull();
    }

    @Test
    public void iexSymbolsTest() {
        final List<Symbol> symbols = cloudClient.executeRequest(new IEXSymbolsRequestBuilder()
                .build());
        assertThat(symbols).isNotNull();
    }

    @Test
    public void exchangeSymbolsTest() {
        final List<ExchangeSymbol> result = cloudClient.executeRequest(new ExchangeSymbolsRequestBuilder()
                .withExchange("LON")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void regionSymbolsTest() {
        final List<ExchangeSymbol> result = cloudClient.executeRequest(new RegionSymbolsRequestBuilder()
                .withRegion("GB")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void exchangesTest() {
        final List<Exchange> result = cloudClient.executeRequest(new ExchangeRequestBuilder().build());
        assertThat(result).isNotNull();
    }

    @Test
    public void usExchangesTest() {
        final List<UsExchange> result = cloudClient.executeRequest(new UsExchangeRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void usHolidayAndTradingDateTest() {
        final List<HolidayAndTradingDate> result = cloudClient.executeRequest(new UsHolidayAndTradingDateRequestBuilder()
                .withType(DateType.TRADE)
                .withDirection(DateDirection.NEXT)
                .build());
        assertThat(result).isNotNull();
    }

}
