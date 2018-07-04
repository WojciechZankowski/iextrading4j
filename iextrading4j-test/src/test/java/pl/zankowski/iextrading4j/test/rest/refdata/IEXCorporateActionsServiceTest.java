package pl.zankowski.iextrading4j.test.rest.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.DelistingReason;
import pl.zankowski.iextrading4j.api.refdata.FinancialStatus;
import pl.zankowski.iextrading4j.api.refdata.Flag;
import pl.zankowski.iextrading4j.api.refdata.IEXCorporateActions;
import pl.zankowski.iextrading4j.api.refdata.IssueEvent;
import pl.zankowski.iextrading4j.api.refdata.ListingCenter;
import pl.zankowski.iextrading4j.api.refdata.LuldTier;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXCorporateActionsRequestBuilder;
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

public class IEXCorporateActionsServiceTest extends BaseRestServiceTest {

    @Test
    public void corporateActionsServiceTest() {
        stubFor(get(urlEqualTo("/ref-data/daily-list/corporate-actions/sample"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/refdata/IEXCorporateActions.json")));

        final List<IEXCorporateActions> corporateActionsList = iexTradingClient.executeRequest(new IEXCorporateActionsRequestBuilder()
                .withSample()
                .build());

        assertThat(corporateActionsList).hasSize(2);

        final IEXCorporateActions corporateActions = corporateActionsList.get(0);
        assertThat(corporateActions.getRecordId()).isEqualTo(" CA20171108153808144");
        assertThat(corporateActions.getDailyListTimestamp()).isEqualTo(LocalDateTime.of(2017, 11, 8, 17, 0, 0));
        assertThat(corporateActions.getEffectiveDate()).isEqualTo(LocalDate.of(2017, 11, 10));
        assertThat(corporateActions.getIssueEvent()).isEqualTo(IssueEvent.ANTICIPATED_SECURITY_ADDITION);
        assertThat(corporateActions.getCurrentSymbolInINETSymbology()).isEqualTo("ZEXIT-");
        assertThat(corporateActions.getCurrentSymbolInCQSSymbology()).isEqualTo("ZEXITp");
        assertThat(corporateActions.getCurrentSymbolInCMSSymbology()).isEqualTo("ZEXIT PR");
        assertThat(corporateActions.getNewSymbolInINETSymbology()).isEmpty();
        assertThat(corporateActions.getNewSymbolInCQSSymbology()).isEmpty();
        assertThat(corporateActions.getNewSymbolInCMSSymbology()).isEmpty();
        assertThat(corporateActions.getCurrentSecurityName()).isEqualTo("ZEXIT Preffered Stock");
        assertThat(corporateActions.getNewSecurityName()).isEmpty();
        assertThat(corporateActions.getCurrentCompanyName()).isEqualTo("ZEXIT Test Company");
        assertThat(corporateActions.getNewCompanyName()).isEmpty();
        assertThat(corporateActions.getCurrentListingCenter()).isEqualTo(ListingCenter.NOT_AVAILABLE);
        assertThat(corporateActions.getNewListingCenter()).isEqualTo(ListingCenter.INVESTORS_EXCHANGE);
        assertThat(corporateActions.getDelistingReason()).isEqualTo(DelistingReason.NOT_DELISTED);
        assertThat(corporateActions.getCurrentRoundLotSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(corporateActions.getNewRoundLotSize()).isNull();
        assertThat(corporateActions.getCurrentLULDTierIndicator()).isEqualTo(LuldTier.NOT_APPLICABLE);
        assertThat(corporateActions.getNewLULDTierIndicator()).isEqualTo(LuldTier.NOT_AVAILABLE);
        assertThat(corporateActions.getExpirationDate()).isNull();
        assertThat(corporateActions.getSeparationDate()).isNull();
        assertThat(corporateActions.getSettlementDate()).isNull();
        assertThat(corporateActions.getMaturityDate()).isNull();
        assertThat(corporateActions.getRedemptionDate()).isNull();
        assertThat(corporateActions.getCurrentFinancialStatus()).isEqualTo(FinancialStatus.NORMAL);
        assertThat(corporateActions.getNewFinancialStatus()).isEqualTo(FinancialStatus.NOT_AVAILABLE);
        assertThat(corporateActions.getWhenIssuedFlag()).isEqualTo(Flag.NO);
        assertThat(corporateActions.getWhenDistributedFlag()).isEqualTo(Flag.NO);
        assertThat(corporateActions.getIpoFlag()).isEqualTo(Flag.NO);
        assertThat(corporateActions.getNotesForEachEntry()).isEqualTo("New preferred ZIEXT security");
        assertThat(corporateActions.getRecordUpdateTime()).isEqualTo(LocalDateTime.of(2017, 11, 8, 16, 34, 43));
    }


}
