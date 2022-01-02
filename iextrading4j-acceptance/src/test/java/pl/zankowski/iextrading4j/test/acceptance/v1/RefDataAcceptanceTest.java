package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.*;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RefDataAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    void symbolsTest() {
        final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new SymbolsRequestBuilder()
                .build());
        assertThat(symbols).isNotNull();
    }

    @Test
    void iexSymbolsTest() {
        final List<Symbol> symbols = cloudClient.executeRequest(new IEXSymbolsRequestBuilder()
                .build());
        assertThat(symbols).isNotNull();
    }

    @Test
    void exchangeSymbolsTest() {
        final List<ExchangeSymbol> result = cloudClient.executeRequest(new ExchangeSymbolsRequestBuilder()
                .withExchange("LON")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void regionSymbolsTest() {
        final List<ExchangeSymbol> result = cloudClient.executeRequest(new RegionSymbolsRequestBuilder()
                .withRegion("GB")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void exchangesTest() {
        final List<Exchange> result = cloudClient.executeRequest(new ExchangeRequestBuilder().build());
        assertThat(result).isNotNull();
    }

    @Test
    void usExchangesTest() {
        final List<UsExchange> result = cloudClient.executeRequest(new UsExchangeRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void usHolidayAndTradingDateTest() {
        final List<HolidayAndTradingDate> result = cloudClient.executeRequest(new UsHolidayAndTradingDateRequestBuilder()
                .withType(DateType.TRADE)
                .withDirection(DateDirection.NEXT)
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void sectorTest() {
        final List<Sector> result = cloudClient.executeRequest(new SectorRequestBuilder().build());
        assertThat(result).isNotNull();
    }

    @Test
    void tagsTest() {
        final List<Tag> result = cloudClient.executeRequest(new TagRequestBuilder().build());
        assertThat(result).isNotNull();
    }

    @Disabled("Message received from IEX Trading: This endpoint is unavailable at this time")
    @Test
    void isinTest() {
        final List<List<SymbolMapping>> result = cloudClient.executeRequest(new IsinMapperRequestBuilder()
                .addIsin("US0378331005")
                .build());
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void optionsTest() {
        final Map<String, List<String>> result = cloudClient.executeRequest(new OptionsSymbolsRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void searchSymbolTest() {
        final List<SymbolDescription> result = cloudClient.executeRequest(new SearchSymbolRequestBuilder()
                .withFragment("apple")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    void cryptoSymbolsTest() {
        final List<CryptoSymbols> result = cloudClient.executeRequest(new CryptoSymbolsRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

}
