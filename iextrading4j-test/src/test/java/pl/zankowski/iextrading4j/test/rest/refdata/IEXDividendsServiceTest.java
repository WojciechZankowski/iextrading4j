package pl.zankowski.iextrading4j.test.rest.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.DividendTypeId;
import pl.zankowski.iextrading4j.api.refdata.EventType;
import pl.zankowski.iextrading4j.api.refdata.IEXDividends;
import pl.zankowski.iextrading4j.api.refdata.PaymentFrequency;
import pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXDividendsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class IEXDividendsServiceTest extends BaseRestServiceTest {

    @Test
    public void dividendsServiceTest() {
        stubFor(get(urlEqualTo("/ref-data/daily-list/dividends/sample"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/refdata/IEXDividends.json")));

        final List<IEXDividends> dividendsList = iexTradingClient.executeRequest(new IEXDividendsRequestBuilder()
                .withSample()
                .build());

        assertThat(dividendsList).hasSize(1);

        final IEXDividends dividends = dividendsList.get(0);
        assertThat(dividends.getRecordId()).isEqualTo(" DV20171108154436478");
        assertThat(dividends.getDailyListTimestamp()).isEqualTo(LocalDateTime.of(2017, 11, 8, 17, 0, 0));
        assertThat(dividends.getEventType()).isEqualTo(EventType.CHANGE);
        assertThat(dividends.getSymbolInINETSymbology()).isEqualTo("ZEXIT");
        assertThat(dividends.getSymbolInCQSSymbology()).isEqualTo("ZEXIT");
        assertThat(dividends.getSymbolInCMSSymbology()).isEqualTo("ZEXIT");
        assertThat(dividends.getSecurityName()).isEqualTo("ZEXIT Common Stock");
        assertThat(dividends.getCompanyName()).isEqualTo("ZEXIT Test Company");
        assertThat(dividends.getDeclarationDate()).isEqualTo(LocalDate.of(2017, 11, 1));
        assertThat(dividends.getAmountDescription()).isEqualTo("fnl");
        assertThat(dividends.getPaymentFrequency()).isEqualTo(PaymentFrequency.ONE_TIME);
        assertThat(dividends.getExDate()).isEqualTo(LocalDate.of(2017, 11, 9));
        assertThat(dividends.getRecordDate()).isEqualTo(LocalDate.of(2017, 11, 13));
        assertThat(dividends.getPaymentDate()).isEqualTo(LocalDate.of(2017, 11, 17));
        assertThat(dividends.getDividendTypeId()).isEqualTo(DividendTypeId.STOCK_DIVIDEND);
        assertThat(dividends.getStockAdjustmentFactor()).isEqualTo(BigDecimal.valueOf(1.1));
        assertThat(dividends.getStockAmount()).isEqualTo(BigDecimal.valueOf(0.1));
        assertThat(dividends.getPostSplitShares()).isEqualTo(BigDecimal.ZERO);
        assertThat(dividends.getPreSplitShares()).isEqualTo(BigDecimal.ZERO);
        assertThat(dividends.getQualifiedDividend()).isEqualTo(QualifiedDividendType.QUALIFIED);
        assertThat(dividends.getExercisePriceAmount()).isEqualTo(BigDecimal.ZERO);
        assertThat(dividends.getElectionorExpirationDate()).isNull();
        assertThat(dividends.getGrossAmount()).isEqualTo(BigDecimal.ZERO);
        assertThat(dividends.getNetAmount()).isEqualTo(BigDecimal.ZERO);
        assertThat(dividends.getBasisNotes()).isEmpty();
        assertThat(dividends.getNotesForEachEntry()).isEqualTo("ZEXIT is paying a 10% stock dividend");
        assertThat(dividends.getRecordUpdateTime()).isEqualTo(LocalDateTime.of(2017, 11, 8, 16, 48, 47));
    }

}
