package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Exchange;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.v1.HolidayAndTradingDate;
import pl.zankowski.iextrading4j.api.refdata.v1.Sector;
import pl.zankowski.iextrading4j.api.refdata.v1.Symbol;
import pl.zankowski.iextrading4j.api.refdata.v1.SymbolDescription;
import pl.zankowski.iextrading4j.api.refdata.v1.SymbolMapping;
import pl.zankowski.iextrading4j.api.refdata.v1.Tag;
import pl.zankowski.iextrading4j.api.refdata.v1.UsExchange;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.DateDirection;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.DateType;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.ExchangeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.ExchangeSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.IEXSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.IsinMapperRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.OptionsSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.RegionSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SearchSymbolRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SectorRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.TagRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.UsExchangeRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.UsHolidayAndTradingDateRequestBuilder;

import java.util.List;
import java.util.Map;

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

    @Test
    public void sectorTest() {
        final List<Sector> result = cloudClient.executeRequest(new SectorRequestBuilder().build());
        assertThat(result).isNotNull();
    }

    @Test
    public void tagsTest() {
        final List<Tag> result = cloudClient.executeRequest(new TagRequestBuilder().build());
        assertThat(result).isNotNull();
    }

    @Test
    public void isinTest() {
        final List<List<SymbolMapping>> result = cloudClient.executeRequest(new IsinMapperRequestBuilder()
                .addIsin("US0378331005")
                .build());
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    public void optionsTest() {
        final Map<String, List<String>> result = cloudClient.executeRequest(new OptionsSymbolsRequestBuilder()
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void searchSymbolTest() {
        final List<SymbolDescription> result = cloudClient.executeRequest(new SearchSymbolRequestBuilder()
                .withFragment("apple")
                .build());
        assertThat(result).isNotNull();
    }

}
