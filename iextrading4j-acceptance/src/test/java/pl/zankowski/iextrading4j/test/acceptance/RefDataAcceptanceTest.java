package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.IEXCorporateActions;
import pl.zankowski.iextrading4j.api.refdata.IEXDividends;
import pl.zankowski.iextrading4j.api.refdata.IEXNextDayExDate;
import pl.zankowski.iextrading4j.api.refdata.IEXSymbolDirectory;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXCorporateActionsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXDividendsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXNextDayExDateRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXSymbolDirectoryRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.SymbolsRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Deprecated
public class RefDataAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void symbolsAcceptanceTest() {
        final List<ExchangeSymbol> exchangeSymbolList = iexTradingClient.executeRequest(new SymbolsRequestBuilder()
                .build());
        assertThat(exchangeSymbolList).isNotNull();
    }

    @Test
    public void nextDayExDateAcceptanceTest() {
        final List<IEXNextDayExDate> nextDayExDateList = iexTradingClient.executeRequest(new IEXNextDayExDateRequestBuilder()
                .withSample()
                .build());
        assertThat(nextDayExDateList).isNotNull();
    }

    @Test
    public void corporateActionsAcceptanceTest() {
        final List<IEXCorporateActions> corporateActions = iexTradingClient.executeRequest(new IEXCorporateActionsRequestBuilder()
                .withSample()
                .build());
        assertThat(corporateActions).isNotNull();
    }

    @Test
    public void dividendsAcceptanceTest() {
        final List<IEXDividends> dividendsList = iexTradingClient.executeRequest(new IEXDividendsRequestBuilder()
                .withSample()
                .build());
        assertThat(dividendsList).isNotNull();
    }

    @Test
    public void symbolDirectoryAcceptanceTest() {
        final List<IEXSymbolDirectory> symbolDirectoryList = iexTradingClient.executeRequest(new IEXSymbolDirectoryRequestBuilder()
                .withSample()
                .build());
        assertThat(symbolDirectoryList).isNotNull();
    }

}
