package pl.zankowski.iextrading4j.api.tops;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.tops.builder.TOPSDataBuilder.defaultTOPS;

/**
 * @author Wojciech Zankowski
 */
public class TOPSTest {

    @Test
    public void shouldSuccessfullyCreateEmptyTOPS() {
        TOPS tops = new TOPS();

        assertThat(tops.getSymbol()).isNull();
        assertThat(tops.getMarketPercent()).isEqualTo(0d);
        assertThat(tops.getBidSize()).isEqualTo(0);
        assertThat(tops.getBidPrice()).isEqualTo(0d);
        assertThat(tops.getAskSize()).isEqualTo(0);
        assertThat(tops.getAskPrice()).isEqualTo(0d);
        assertThat(tops.getVolume()).isEqualTo(0L);
        assertThat(tops.getLastSalePrice()).isEqualTo(0d);
        assertThat(tops.getLastSaleSize()).isEqualTo(0);
        assertThat(tops.getLastSaleTime()).isEqualTo(0L);
        assertThat(tops.getLastUpdated()).isEqualTo(0L);
    }

    @Test
    public void shouldSuccessfullyCreateTOPS() {
        final String symbol = "IBM";
        final double marketPercent = 0.0179;
        final int bidSize = 0;
        final double bidPrice = 0.0;
        final int askSize = 0;
        final double askPrice = 0.0;
        final long volume = 62344;
        final double lastSalePrice = 176.45;
        final int lastSaleSize = 100;
        final long lastSaleTime = 1489435198942L;
        final long lastUpdated = 1489435200006L;

        TOPS tops = new TOPS(symbol, marketPercent, bidSize, bidPrice, askSize, askPrice, volume, lastSalePrice,
                lastSaleSize, lastSaleTime, lastUpdated);

        assertTOPS(tops, symbol, marketPercent, bidSize, bidPrice, askSize, askPrice, volume, lastSalePrice,
                lastSaleSize, lastSaleTime, lastUpdated);
    }

    @Test
    public void shouldSuccessfullySetValuesIntoEmptyTOPS() {
        final String symbol = "IBM";
        final double marketPercent = 0.0179;
        final int bidSize = 0;
        final double bidPrice = 0.0;
        final int askSize = 0;
        final double askPrice = 0.0;
        final long volume = 62344;
        final double lastSalePrice = 176.45;
        final int lastSaleSize = 100;
        final long lastSaleTime = 1489435198942L;
        final long lastUpdated = 1489435200006L;

        TOPS tops = new TOPS();
        tops.setSymbol(symbol);
        tops.setMarketPercent(marketPercent);
        tops.setBidSize(bidSize);
        tops.setBidPrice(bidPrice);
        tops.setAskSize(askSize);
        tops.setAskPrice(askPrice);
        tops.setVolume(volume);
        tops.setLastSalePrice(lastSalePrice);
        tops.setLastSaleSize(lastSaleSize);
        tops.setLastSaleTime(lastSaleTime);
        tops.setLastUpdated(lastUpdated);

        assertTOPS(tops, symbol, marketPercent, bidSize, bidPrice, askSize, askPrice, volume, lastSalePrice,
                lastSaleSize, lastSaleTime, lastUpdated);
    }

    @Test
    public void shouldSuccessfullyEqualsTwoTOPS() {
        TOPS tops_1 = defaultTOPS();
        TOPS tops_2 = defaultTOPS();

        assertThat(tops_1.equals(tops_2)).isTrue();
        assertThat(tops_1.hashCode()).isEqualTo(tops_2.hashCode());
    }

    private void assertTOPS(TOPS tops, String symbol, double marketPercent, int bidSize, double bidPrice, int askSize, double askPrice,
                            long volume, double lastSalePrice, int lastSaleSize, long lastSaleTime, long lastUpdated) {
        assertThat(tops.getSymbol()).isEqualTo(symbol);
        assertThat(tops.getMarketPercent()).isEqualTo(marketPercent);
        assertThat(tops.getBidSize()).isEqualTo(bidSize);
        assertThat(tops.getBidPrice()).isEqualTo(bidPrice);
        assertThat(tops.getAskSize()).isEqualTo(askSize);
        assertThat(tops.getAskPrice()).isEqualTo(askPrice);
        assertThat(tops.getVolume()).isEqualTo(volume);
        assertThat(tops.getLastSalePrice()).isEqualTo(lastSalePrice);
        assertThat(tops.getLastSaleSize()).isEqualTo(lastSaleSize);
        assertThat(tops.getLastSaleTime()).isEqualTo(lastSaleTime);
        assertThat(tops.getLastUpdated()).isEqualTo(lastUpdated);
    }

}
