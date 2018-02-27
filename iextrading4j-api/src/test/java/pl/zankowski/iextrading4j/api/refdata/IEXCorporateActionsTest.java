package pl.zankowski.iextrading4j.api.refdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXCorporateActionsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String recordId = fixture.create(String.class);
        final LocalDateTime dailyListTimestamp = fixture.create(LocalDateTime.class);
        final LocalDate effectiveDate = fixture.create(LocalDate.class);
        final IssueEvent issueEvent = fixture.create(IssueEvent.class);
        final String currentSymbolInINETSymbology = fixture.create(String.class);
        final String currentSymbolInCQSSymbology = fixture.create(String.class);
        final String currentSymbolInCMSSymbology = fixture.create(String.class);
        final String newSymbolInINETSymbology = fixture.create(String.class);
        final String newSymbolInCQSSymbology = fixture.create(String.class);
        final String newSymbolInCMSSymbology = fixture.create(String.class);
        final String currentSecurityName = fixture.create(String.class);
        final String newSecurityName = fixture.create(String.class);
        final String currentCompanyName = fixture.create(String.class);
        final String newCompanyName = fixture.create(String.class);
        final ListingCenter currentListingCenter = fixture.create(ListingCenter.class);
        final ListingCenter newListingCenter = fixture.create(ListingCenter.class);
        final DelistingReason delistingReason = fixture.create(DelistingReason.class);
        final BigDecimal currentRoundLotSize = fixture.create(BigDecimal.class);
        final BigDecimal newRoundLotSize = fixture.create(BigDecimal.class);
        final LuldTier currentLULDTierIndicator = fixture.create(LuldTier.class);
        final LuldTier newLULDTierIndicator = fixture.create(LuldTier.class);
        final LocalDate expirationDate = fixture.create(LocalDate.class);
        final LocalDate separationDate = fixture.create(LocalDate.class);
        final LocalDate settlementDate = fixture.create(LocalDate.class);
        final LocalDate maturityDate = fixture.create(LocalDate.class);
        final LocalDate redemptionDate = fixture.create(LocalDate.class);
        final FinancialStatus currentFinancialStatus = fixture.create(FinancialStatus.class);
        final FinancialStatus newFinancialStatus = fixture.create(FinancialStatus.class);
        final Flag whenIssuedFlag = fixture.create(Flag.class);
        final Flag whenDistributedFlag = fixture.create(Flag.class);
        final Flag ipoFlag = fixture.create(Flag.class);
        final String notesForEachEntry = fixture.create(String.class);
        final LocalDateTime recordUpdateTime = fixture.create(LocalDateTime.class);

        final IEXCorporateActions IEXCorporateActions = new IEXCorporateActions(recordId, dailyListTimestamp, effectiveDate,
                issueEvent, currentSymbolInINETSymbology, currentSymbolInCQSSymbology, currentSymbolInCMSSymbology,
                newSymbolInINETSymbology, newSymbolInCQSSymbology, newSymbolInCMSSymbology, currentSecurityName,
                newSecurityName, currentCompanyName, newCompanyName, currentListingCenter, newListingCenter,
                delistingReason, currentRoundLotSize, newRoundLotSize, currentLULDTierIndicator, newLULDTierIndicator,
                expirationDate, separationDate, settlementDate, maturityDate, redemptionDate, currentFinancialStatus,
                newFinancialStatus, whenIssuedFlag, whenDistributedFlag, ipoFlag, notesForEachEntry, recordUpdateTime);

        assertThat(IEXCorporateActions.getRecordId()).isEqualTo(recordId);
        assertThat(IEXCorporateActions.getDailyListTimestamp()).isEqualTo(dailyListTimestamp);
        assertThat(IEXCorporateActions.getEffectiveDate()).isEqualTo(effectiveDate);
        assertThat(IEXCorporateActions.getIssueEvent()).isEqualTo(issueEvent);
        assertThat(IEXCorporateActions.getCurrentSymbolInINETSymbology()).isEqualTo(currentSymbolInINETSymbology);
        assertThat(IEXCorporateActions.getCurrentSymbolInCQSSymbology()).isEqualTo(currentSymbolInCQSSymbology);
        assertThat(IEXCorporateActions.getCurrentSymbolInCMSSymbology()).isEqualTo(currentSymbolInCMSSymbology);
        assertThat(IEXCorporateActions.getNewSymbolInINETSymbology()).isEqualTo(newSymbolInINETSymbology);
        assertThat(IEXCorporateActions.getNewSymbolInCQSSymbology()).isEqualTo(newSymbolInCQSSymbology);
        assertThat(IEXCorporateActions.getNewSymbolInCMSSymbology()).isEqualTo(newSymbolInCMSSymbology);
        assertThat(IEXCorporateActions.getCurrentSecurityName()).isEqualTo(currentSecurityName);
        assertThat(IEXCorporateActions.getNewSecurityName()).isEqualTo(newSecurityName);
        assertThat(IEXCorporateActions.getCurrentCompanyName()).isEqualTo(currentCompanyName);
        assertThat(IEXCorporateActions.getNewCompanyName()).isEqualTo(newCompanyName);
        assertThat(IEXCorporateActions.getCurrentListingCenter()).isEqualTo(currentListingCenter);
        assertThat(IEXCorporateActions.getNewListingCenter()).isEqualTo(newListingCenter);
        assertThat(IEXCorporateActions.getDelistingReason()).isEqualTo(delistingReason);
        assertThat(IEXCorporateActions.getCurrentRoundLotSize()).isEqualTo(currentRoundLotSize);
        assertThat(IEXCorporateActions.getNewRoundLotSize()).isEqualTo(newRoundLotSize);
        assertThat(IEXCorporateActions.getCurrentLULDTierIndicator()).isEqualTo(currentLULDTierIndicator);
        assertThat(IEXCorporateActions.getNewLULDTierIndicator()).isEqualTo(newLULDTierIndicator);
        assertThat(IEXCorporateActions.getExpirationDate()).isEqualTo(expirationDate);
        assertThat(IEXCorporateActions.getSeparationDate()).isEqualTo(separationDate);
        assertThat(IEXCorporateActions.getSettlementDate()).isEqualTo(settlementDate);
        assertThat(IEXCorporateActions.getMaturityDate()).isEqualTo(maturityDate);
        assertThat(IEXCorporateActions.getRedemptionDate()).isEqualTo(redemptionDate);
        assertThat(IEXCorporateActions.getCurrentFinancialStatus()).isEqualTo(currentFinancialStatus);
        assertThat(IEXCorporateActions.getNewFinancialStatus()).isEqualTo(newFinancialStatus);
        assertThat(IEXCorporateActions.getWhenIssuedFlag()).isEqualTo(whenIssuedFlag);
        assertThat(IEXCorporateActions.getWhenDistributedFlag()).isEqualTo(whenDistributedFlag);
        assertThat(IEXCorporateActions.getIpoFlag()).isEqualTo(ipoFlag);
        assertThat(IEXCorporateActions.getNotesForEachEntry()).isEqualTo(notesForEachEntry);
        assertThat(IEXCorporateActions.getRecordUpdateTime()).isEqualTo(recordUpdateTime);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXCorporateActions.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IEXCorporateActions.class))
                .verify();
    }

}
