package pl.zankowski.iextrading4j.api.stats;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoricalStatsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal averageDailyVolume = fixture.create(BigDecimal.class);
        final BigDecimal averageDailyRoutedVolume = fixture.create(BigDecimal.class);
        final BigDecimal averageMarketShare = fixture.create(BigDecimal.class);
        final BigDecimal averageOrderSize = fixture.create(BigDecimal.class);
        final BigDecimal averageFillSize = fixture.create(BigDecimal.class);
        final BigDecimal bin100Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin101Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin200Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin300Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin400Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin500Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin1000Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin5000Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin10000Percent = fixture.create(BigDecimal.class);
        final BigDecimal bin10000Trades = fixture.create(BigDecimal.class);
        final BigDecimal bin20000Trades = fixture.create(BigDecimal.class);
        final BigDecimal bin50000Trades = fixture.create(BigDecimal.class);
        final BigDecimal uniqueSymbolsTraded = fixture.create(BigDecimal.class);
        final BigDecimal blockPercent = fixture.create(BigDecimal.class);
        final BigDecimal selfCrossPercent = fixture.create(BigDecimal.class);
        final BigDecimal etfPercent = fixture.create(BigDecimal.class);
        final BigDecimal largeCapPercent = fixture.create(BigDecimal.class);
        final BigDecimal midCapPercent = fixture.create(BigDecimal.class);
        final BigDecimal smallCapPercent = fixture.create(BigDecimal.class);
        final BigDecimal venueARCXFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueBATSFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueBATYFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueEDGAFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueEDGXFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueOverallFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueXASEFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueXBOSFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueXCHIFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueXCISFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueXNGSFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueXNYSFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueXPHLFirstWaveWeight = fixture.create(BigDecimal.class);
        final BigDecimal venueARCXFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueBATSFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueBATYFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueEDGAFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueEDGXFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueOverallFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueXASEFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueXBOSFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueXCHIFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueXCISFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueXNGSFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueXNYSFirstWaveRate = fixture.create(BigDecimal.class);
        final BigDecimal venueXPHLFirstWaveRate = fixture.create(BigDecimal.class);

        final HistoricalStats historicalStats = new HistoricalStats(averageDailyVolume, averageDailyRoutedVolume,
                averageMarketShare, averageOrderSize, averageFillSize, bin100Percent, bin101Percent, bin200Percent,
                bin300Percent, bin400Percent, bin500Percent, bin1000Percent, bin5000Percent, bin10000Percent,
                bin10000Trades, bin20000Trades, bin50000Trades, uniqueSymbolsTraded, blockPercent, selfCrossPercent,
                etfPercent, largeCapPercent, midCapPercent, smallCapPercent, venueARCXFirstWaveWeight,
                venueBATSFirstWaveWeight, venueBATYFirstWaveWeight, venueEDGAFirstWaveWeight, venueEDGXFirstWaveWeight,
                venueOverallFirstWaveWeight, venueXASEFirstWaveWeight, venueXBOSFirstWaveWeight, venueXCHIFirstWaveWeight,
                venueXCISFirstWaveWeight, venueXNGSFirstWaveWeight, venueXNYSFirstWaveWeight, venueXPHLFirstWaveWeight,
                venueARCXFirstWaveRate, venueBATSFirstWaveRate, venueBATYFirstWaveRate, venueEDGAFirstWaveRate,
                venueEDGXFirstWaveRate, venueOverallFirstWaveRate, venueXASEFirstWaveRate, venueXBOSFirstWaveRate,
                venueXCHIFirstWaveRate, venueXCISFirstWaveRate, venueXNGSFirstWaveRate, venueXNYSFirstWaveRate,
                venueXPHLFirstWaveRate);

        assertThat(historicalStats.getAverageDailyVolume()).isEqualTo(averageDailyVolume);
        assertThat(historicalStats.getAverageDailyRoutedVolume()).isEqualTo(averageDailyRoutedVolume);
        assertThat(historicalStats.getAverageMarketShare()).isEqualTo(averageMarketShare);
        assertThat(historicalStats.getAverageOrderSize()).isEqualTo(averageOrderSize);
        assertThat(historicalStats.getAverageFillSize()).isEqualTo(averageFillSize);
        assertThat(historicalStats.getBin100Percent()).isEqualTo(bin100Percent);
        assertThat(historicalStats.getBin101Percent()).isEqualTo(bin101Percent);
        assertThat(historicalStats.getBin200Percent()).isEqualTo(bin200Percent);
        assertThat(historicalStats.getBin300Percent()).isEqualTo(bin300Percent);
        assertThat(historicalStats.getBin400Percent()).isEqualTo(bin400Percent);
        assertThat(historicalStats.getBin500Percent()).isEqualTo(bin500Percent);
        assertThat(historicalStats.getBin1000Percent()).isEqualTo(bin1000Percent);
        assertThat(historicalStats.getBin5000Percent()).isEqualTo(bin5000Percent);
        assertThat(historicalStats.getBin10000Percent()).isEqualTo(bin10000Percent);
        assertThat(historicalStats.getBin10000Trades()).isEqualTo(bin10000Trades);
        assertThat(historicalStats.getBin20000Trades()).isEqualTo(bin20000Trades);
        assertThat(historicalStats.getBin50000Trades()).isEqualTo(bin50000Trades);
        assertThat(historicalStats.getUniqueSymbolsTraded()).isEqualTo(uniqueSymbolsTraded);
        assertThat(historicalStats.getBlockPercent()).isEqualTo(blockPercent);
        assertThat(historicalStats.getSelfCrossPercent()).isEqualTo(selfCrossPercent);
        assertThat(historicalStats.getEtfPercent()).isEqualTo(etfPercent);
        assertThat(historicalStats.getLargeCapPercent()).isEqualTo(largeCapPercent);
        assertThat(historicalStats.getMidCapPercent()).isEqualTo(midCapPercent);
        assertThat(historicalStats.getSmallCapPercent()).isEqualTo(smallCapPercent);
        assertThat(historicalStats.getVenueARCXFirstWaveWeight()).isEqualTo(venueARCXFirstWaveWeight);
        assertThat(historicalStats.getVenueBATSFirstWaveWeight()).isEqualTo(venueBATSFirstWaveWeight);
        assertThat(historicalStats.getVenueBATYFirstWaveWeight()).isEqualTo(venueBATYFirstWaveWeight);
        assertThat(historicalStats.getVenueEDGAFirstWaveWeight()).isEqualTo(venueEDGAFirstWaveWeight);
        assertThat(historicalStats.getVenueEDGXFirstWaveWeight()).isEqualTo(venueEDGXFirstWaveWeight);
        assertThat(historicalStats.getVenueOverallFirstWaveWeight()).isEqualTo(venueOverallFirstWaveWeight);
        assertThat(historicalStats.getVenueXASEFirstWaveWeight()).isEqualTo(venueXASEFirstWaveWeight);
        assertThat(historicalStats.getVenueXBOSFirstWaveWeight()).isEqualTo(venueXBOSFirstWaveWeight);
        assertThat(historicalStats.getVenueXCHIFirstWaveWeight()).isEqualTo(venueXCHIFirstWaveWeight);
        assertThat(historicalStats.getVenueXCISFirstWaveWeight()).isEqualTo(venueXCISFirstWaveWeight);
        assertThat(historicalStats.getVenueXNGSFirstWaveWeight()).isEqualTo(venueXNGSFirstWaveWeight);
        assertThat(historicalStats.getVenueXNYSFirstWaveWeight()).isEqualTo(venueXNYSFirstWaveWeight);
        assertThat(historicalStats.getVenueXPHLFirstWaveWeight()).isEqualTo(venueXPHLFirstWaveWeight);
        assertThat(historicalStats.getVenueARCXFirstWaveRate()).isEqualTo(venueARCXFirstWaveRate);
        assertThat(historicalStats.getVenueBATSFirstWaveRate()).isEqualTo(venueBATSFirstWaveRate);
        assertThat(historicalStats.getVenueBATYFirstWaveRate()).isEqualTo(venueBATYFirstWaveRate);
        assertThat(historicalStats.getVenueEDGAFirstWaveRate()).isEqualTo(venueEDGAFirstWaveRate);
        assertThat(historicalStats.getVenueEDGXFirstWaveRate()).isEqualTo(venueEDGXFirstWaveRate);
        assertThat(historicalStats.getVenueOverallFirstWaveRate()).isEqualTo(venueOverallFirstWaveRate);
        assertThat(historicalStats.getVenueXASEFirstWaveRate()).isEqualTo(venueXASEFirstWaveRate);
        assertThat(historicalStats.getVenueXBOSFirstWaveRate()).isEqualTo(venueXBOSFirstWaveRate);
        assertThat(historicalStats.getVenueXCHIFirstWaveRate()).isEqualTo(venueXCHIFirstWaveRate);
        assertThat(historicalStats.getVenueXCISFirstWaveRate()).isEqualTo(venueXCISFirstWaveRate);
        assertThat(historicalStats.getVenueXNGSFirstWaveRate()).isEqualTo(venueXNGSFirstWaveRate);
        assertThat(historicalStats.getVenueXNYSFirstWaveRate()).isEqualTo(venueXNYSFirstWaveRate);
        assertThat(historicalStats.getVenueXPHLFirstWaveRate()).isEqualTo(venueXPHLFirstWaveRate);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(HistoricalStats.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(HistoricalStats.class))
                .verify();
    }

}
