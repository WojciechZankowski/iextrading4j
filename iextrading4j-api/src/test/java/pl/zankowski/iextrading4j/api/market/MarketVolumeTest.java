package pl.zankowski.iextrading4j.api.market;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.market.builder.MarketVolumeDataBuilder.defaultMarketVolume;

/**
 * @author Wojciech Zankowski
 */
public class MarketVolumeTest {

    @Test
    public void shouldSuccessfullyCreateMarketVolume() {
        final String mic = "XCHI";
        final String tapeId = "M";
        final String venueName = "CHX";
        final long volume = 16475000;
        final long tapeA = 5155704;
        final long tapeB = 7013233;
        final long tapeC = 4306063;
        final double marketPercent = 0.00266;
        final long lastUpdated = 1489438707493L;

        MarketVolume marketVolume = new MarketVolume(mic, tapeId, venueName, volume, tapeA, tapeB,
                tapeC, marketPercent, lastUpdated);
        assertMarketVolume(marketVolume, mic, tapeId, venueName, volume, tapeA, tapeB, tapeC, marketPercent, lastUpdated);
    }

    @Test
    public void shouldSuccessfullyCompareMarketVolumes() {
        MarketVolume marketVolume_1 = defaultMarketVolume();
        MarketVolume marketVolume_2 = defaultMarketVolume();

        assertThat(marketVolume_1.equals(marketVolume_2)).isTrue();
        assertThat(marketVolume_1.hashCode()).isEqualTo(marketVolume_2.hashCode());
    }

    private void assertMarketVolume(MarketVolume marketVolume, String mic, String tapeId, String venueName,
                                    long volume, long tapeA, long tapeB, long tapeC, double marketPercent, long lastUpdated) {
        assertThat(marketVolume.getMic()).isEqualTo(mic);
        assertThat(marketVolume.getTapeId()).isEqualTo(tapeId);
        assertThat(marketVolume.getVenueName()).isEqualTo(venueName);
        assertThat(marketVolume.getVolume()).isEqualTo(volume);
        assertThat(marketVolume.getTapeA()).isEqualTo(tapeA);
        assertThat(marketVolume.getTapeB()).isEqualTo(tapeB);
        assertThat(marketVolume.getTapeC()).isEqualTo(tapeC);
        assertThat(marketVolume.getMarketPercent()).isEqualTo(marketPercent);
        assertThat(marketVolume.getLastUpdated()).isEqualTo(lastUpdated);
    }

}
