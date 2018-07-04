package pl.zankowski.iextrading4j.test.rest.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.DividendTypeId;
import pl.zankowski.iextrading4j.api.refdata.IEXNextDayExDate;
import pl.zankowski.iextrading4j.api.refdata.PaymentFrequency;
import pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXNextDayExDateRequestBuilder;
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

public class IEXNextDayExDateServiceTest extends BaseRestServiceTest {

    @Test
    public void nextDayExDateServiceTest() {
        stubFor(get(urlEqualTo("/ref-data/daily-list/next-day-ex-date/sample"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/refdata/IEXNextDayExDate.json")));

        final List<IEXNextDayExDate> nextDayExDateList = iexTradingClient.executeRequest(new IEXNextDayExDateRequestBuilder()
                .withSample()
                .build());

        assertThat(nextDayExDateList).hasSize(1);

        final IEXNextDayExDate nextDayExDate = nextDayExDateList.get(0);
        assertThat(nextDayExDate.getRecordId()).isEqualTo(" DV20171108154436478");
        assertThat(nextDayExDate.getDailyListTimestamp()).isEqualTo(LocalDateTime.of(2017, 11, 8, 17, 0, 0));
        assertThat(nextDayExDate.getExDate()).isEqualTo(LocalDate.of(2017, 11, 9));
        assertThat(nextDayExDate.getSymbolInINETSymbology()).isEqualTo("ZEXIT");
        assertThat(nextDayExDate.getSymbolInCQSSymbology()).isEqualTo("ZEXIT");
        assertThat(nextDayExDate.getSymbolInCMSSymbology()).isEqualTo("ZEXIT");
        assertThat(nextDayExDate.getSecurityName()).isEqualTo("ZEXIT Common Stock");
        assertThat(nextDayExDate.getCompanyName()).isEqualTo("ZEXIT Test Company");
        assertThat(nextDayExDate.getDividendTypeId()).isEqualTo(DividendTypeId.STOCK_DIVIDEND);
        assertThat(nextDayExDate.getAmountDescription()).isEqualTo("fnl");
        assertThat(nextDayExDate.getPaymentFrequency()).isEqualTo(PaymentFrequency.ONE_TIME);
        assertThat(nextDayExDate.getStockAdjustmentFactor()).isEqualTo(BigDecimal.valueOf(1.1));
        assertThat(nextDayExDate.getStockAmount()).isEqualTo(BigDecimal.valueOf(0.1));
        assertThat(nextDayExDate.getCashAmount()).isEqualTo(BigDecimal.ZERO);
        assertThat(nextDayExDate.getPostSplitShares()).isEqualTo(BigDecimal.ZERO);
        assertThat(nextDayExDate.getPreSplitShares()).isEqualTo(BigDecimal.ZERO);
        assertThat(nextDayExDate.getQualifiedDividend()).isEqualTo(QualifiedDividendType.QUALIFIED);
        assertThat(nextDayExDate.getExercisePriceAmount()).isEqualTo(BigDecimal.ZERO);
        assertThat(nextDayExDate.getElectionorExpirationDate()).isEqualTo(BigDecimal.ZERO);
        assertThat(nextDayExDate.getGrossAmount()).isEqualTo(BigDecimal.ZERO);
        assertThat(nextDayExDate.getNetAmount()).isEqualTo(BigDecimal.ZERO);
        assertThat(nextDayExDate.getBasisNotes()).isEmpty();
        assertThat(nextDayExDate.getNotesForEachEntry()).isEqualTo("ZEXIT is paying a 10% stock dividend");
        assertThat(nextDayExDate.getRecordUpdateTime()).isEqualTo(LocalDateTime.of(2017, 11, 8, 16, 48, 47));
    }

}
