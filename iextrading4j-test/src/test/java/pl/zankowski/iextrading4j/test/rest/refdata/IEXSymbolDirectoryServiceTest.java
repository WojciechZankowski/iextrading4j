package pl.zankowski.iextrading4j.test.rest.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.FinancialStatus;
import pl.zankowski.iextrading4j.api.refdata.Flag;
import pl.zankowski.iextrading4j.api.refdata.IEXSymbolDirectory;
import pl.zankowski.iextrading4j.api.refdata.IssueSubType;
import pl.zankowski.iextrading4j.api.refdata.IssueType;
import pl.zankowski.iextrading4j.api.refdata.LuldTier;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXSymbolDirectoryRequestBuilder;
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

public class IEXSymbolDirectoryServiceTest extends BaseRestServiceTest {

    @Test
    public void symbolDirectoryServiceTest() {
        stubFor(get(urlEqualTo("/ref-data/daily-list/symbol-directory/sample"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/refdata/IEXSymbolDirectory.json")));

        final List<IEXSymbolDirectory> symbolDirectoryList = iexTradingClient.executeRequest(new IEXSymbolDirectoryRequestBuilder()
                .withSample()
                .build());

        assertThat(symbolDirectoryList).hasSize(4);

        final IEXSymbolDirectory symbolDirectory = symbolDirectoryList.get(0);
        assertThat(symbolDirectory.getRecordId()).isEqualTo(" SD20171020161150890");
        assertThat(symbolDirectory.getDailyListTimestamp()).isEqualTo(LocalDateTime.of(2017, 11, 8, 17, 0, 0));
        assertThat(symbolDirectory.getSymbolInINETSymbology()).isEqualTo("ZEXIT");
        assertThat(symbolDirectory.getSymbolInCQSSymbology()).isEqualTo("ZEXIT");
        assertThat(symbolDirectory.getSymbolInCMSSymbology()).isEqualTo("ZEXIT");
        assertThat(symbolDirectory.getSecurityName()).isEqualTo("ZEXIT Common Stock");
        assertThat(symbolDirectory.getCompanyName()).isEqualTo("ZEXIT Test Company");
        assertThat(symbolDirectory.getTestIssue()).isEqualTo(Flag.YES);
        assertThat(symbolDirectory.getIssueDescription()).isEqualTo("Common Stock");
        assertThat(symbolDirectory.getIssueType()).isEqualTo(IssueType.COMMON_STOCK);
        assertThat(symbolDirectory.getIssueSubType()).isEqualTo(IssueSubType.COMMON_SHARES);
        assertThat(symbolDirectory.getSicCode()).isEqualTo("5678");
        assertThat(symbolDirectory.getTransferAgent()).isEqualTo("American Stock Transfer");
        assertThat(symbolDirectory.getFinancialStatus()).isEqualTo(FinancialStatus.NORMAL);
        assertThat(symbolDirectory.getRoundLotSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(symbolDirectory.getPreviousOfficialClosingPrice()).isEqualByComparingTo(BigDecimal.valueOf(10.00));
        assertThat(symbolDirectory.getAdjustedPreviousOfficialClosingPrice()).isEqualTo(BigDecimal.valueOf(9.09));
        assertThat(symbolDirectory.getWhenIssuedFlag()).isEqualTo(Flag.NO);
        assertThat(symbolDirectory.getWhenDistributedFlag()).isEqualTo(Flag.NO);
        assertThat(symbolDirectory.getIpoFlag()).isEqualTo(Flag.NO);
        assertThat(symbolDirectory.getFirstDateListed()).isEqualTo(LocalDate.of(2017, 9, 15));
        assertThat(symbolDirectory.getLuldTierIndicator()).isEqualTo(LuldTier.TIER_1_NMS_STOCKS);
        assertThat(symbolDirectory.getCountryOfIncorporation()).isEqualTo("USA");
        assertThat(symbolDirectory.getLeveragedETPFlag()).isEqualTo(Flag.NO);
        assertThat(symbolDirectory.getLeveragedETPRatio()).isEqualTo(BigDecimal.ZERO);
        assertThat(symbolDirectory.getInverseETPFlag()).isEqualTo(Flag.NO);
        assertThat(symbolDirectory.getRecordUpdateTime()).isEqualTo(LocalDateTime.of(2017, 11, 8, 16, 51, 19));
    }

}
