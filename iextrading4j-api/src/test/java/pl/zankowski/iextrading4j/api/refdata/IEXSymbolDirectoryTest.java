package pl.zankowski.iextrading4j.api.refdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXSymbolDirectoryTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String recordId = fixture.create(String.class);
        final LocalDateTime dailyListTimestamp = fixture.create(LocalDateTime.class);
        final String symbolInINETSymbology = fixture.create(String.class);
        final String symbolInCQSSymbology = fixture.create(String.class);
        final String symbolInCMSSymbology = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final Flag testIssue = fixture.create(Flag.class);
        final String issueDescription = fixture.create(String.class);
        final IssueType issueType = fixture.create(IssueType.class);
        final IssueSubType issueSubType = fixture.create(IssueSubType.class);
        final String sicCode = fixture.create(String.class);
        final String transferAgent = fixture.create(String.class);
        final FinancialStatus financialStatus = fixture.create(FinancialStatus.class);
        final BigDecimal roundLotSize = fixture.create(BigDecimal.class);
        final BigDecimal previousOfficialClosingPrice = fixture.create(BigDecimal.class);
        final BigDecimal adjustedPreviousOfficialClosingPrice = fixture.create(BigDecimal.class);
        final Flag whenIssuedFlag = fixture.create(Flag.class);
        final Flag whenDistributedFlag = fixture.create(Flag.class);
        final Flag ipoFlag = fixture.create(Flag.class);
        final LocalDate firstDateListed = fixture.create(LocalDate.class);
        final LuldTier luldTierIndicator = fixture.create(LuldTier.class);
        final String countryOfIncorporation = fixture.create(String.class);
        final Flag leveragedETPFlag = fixture.create(Flag.class);
        final BigDecimal leveragedETPRatio = fixture.create(BigDecimal.class);
        final Flag inverseETPFlag = fixture.create(Flag.class);
        final LocalDateTime recordUpdateTime = fixture.create(LocalDateTime.class);

        final IEXSymbolDirectory symbolDirectory = new IEXSymbolDirectory(recordId, dailyListTimestamp,
                symbolInINETSymbology, symbolInCQSSymbology, symbolInCMSSymbology, securityName, companyName,
                testIssue, issueDescription, issueType, issueSubType, sicCode, transferAgent, financialStatus,
                roundLotSize, previousOfficialClosingPrice, adjustedPreviousOfficialClosingPrice, whenIssuedFlag,
                whenDistributedFlag, ipoFlag, firstDateListed, luldTierIndicator, countryOfIncorporation,
                leveragedETPFlag, leveragedETPRatio, inverseETPFlag, recordUpdateTime);

        assertThat(symbolDirectory.getRecordId()).isEqualTo(recordId);
        assertThat(symbolDirectory.getDailyListTimestamp()).isEqualTo(dailyListTimestamp);
        assertThat(symbolDirectory.getSymbolInINETSymbology()).isEqualTo(symbolInINETSymbology);
        assertThat(symbolDirectory.getSymbolInCQSSymbology()).isEqualTo(symbolInCQSSymbology);
        assertThat(symbolDirectory.getSymbolInCMSSymbology()).isEqualTo(symbolInCMSSymbology);
        assertThat(symbolDirectory.getSecurityName()).isEqualTo(securityName);
        assertThat(symbolDirectory.getCompanyName()).isEqualTo(companyName);
        assertThat(symbolDirectory.getTestIssue()).isEqualTo(testIssue);
        assertThat(symbolDirectory.getIssueDescription()).isEqualTo(issueDescription);
        assertThat(symbolDirectory.getIssueType()).isEqualTo(issueType);
        assertThat(symbolDirectory.getIssueSubType()).isEqualTo(issueSubType);
        assertThat(symbolDirectory.getSicCode()).isEqualTo(sicCode);
        assertThat(symbolDirectory.getTransferAgent()).isEqualTo(transferAgent);
        assertThat(symbolDirectory.getFinancialStatus()).isEqualTo(financialStatus);
        assertThat(symbolDirectory.getRoundLotSize()).isEqualTo(roundLotSize);
        assertThat(symbolDirectory.getPreviousOfficialClosingPrice()).isEqualTo(previousOfficialClosingPrice);
        assertThat(symbolDirectory.getAdjustedPreviousOfficialClosingPrice()).isEqualTo(adjustedPreviousOfficialClosingPrice);
        assertThat(symbolDirectory.getWhenIssuedFlag()).isEqualTo(whenIssuedFlag);
        assertThat(symbolDirectory.getWhenDistributedFlag()).isEqualTo(whenDistributedFlag);
        assertThat(symbolDirectory.getIpoFlag()).isEqualTo(ipoFlag);
        assertThat(symbolDirectory.getFirstDateListed()).isEqualTo(firstDateListed);
        assertThat(symbolDirectory.getLuldTierIndicator()).isEqualTo(luldTierIndicator);
        assertThat(symbolDirectory.getCountryOfIncorporation()).isEqualTo(countryOfIncorporation);
        assertThat(symbolDirectory.getLeveragedETPFlag()).isEqualTo(leveragedETPFlag);
        assertThat(symbolDirectory.getLeveragedETPRatio()).isEqualTo(leveragedETPRatio);
        assertThat(symbolDirectory.getInverseETPFlag()).isEqualTo(inverseETPFlag);
        assertThat(symbolDirectory.getRecordUpdateTime()).isEqualTo(recordUpdateTime);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXSymbolDirectory.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(IEXSymbolDirectory.class))
                .verify();
    }

}
