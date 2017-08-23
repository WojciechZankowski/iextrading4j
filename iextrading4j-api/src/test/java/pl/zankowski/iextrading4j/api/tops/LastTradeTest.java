package pl.zankowski.iextrading4j.api.tops;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.tops.builder.LastTradeDataBuilder.defaultLastTrade;

/**
 * @author Wojciech Zankowski
 */
public class LastTradeTest {
    @Test
    public void shouldSuccessfullyCreateLastTrade() {
        final String symbol = "FTR";
        final double price = 2.545;
        final int size = 100;
        final long time = 1489435195124L;

        LastTrade lastTrade = new LastTrade(symbol, price, size, time);

        assertLastTrade(lastTrade, symbol, price, size, time);
    }

    @Test
    public void shouldSuccessfullyEqualTwoLastTrades() {
        LastTrade lastTrade_1 = defaultLastTrade();
        LastTrade lastTrade_2 = defaultLastTrade();

        assertThat(lastTrade_1.equals(lastTrade_2)).isTrue();
        assertThat(lastTrade_1.hashCode()).isEqualTo(lastTrade_2.hashCode());
    }

    private void assertLastTrade(LastTrade lastTrade, String symbol, double price, int size, long time) {
        assertThat(lastTrade.getSymbol()).isEqualTo(symbol);
        assertThat(lastTrade.getPrice()).isEqualTo(price);
        assertThat(lastTrade.getSize()).isEqualTo(size);
        assertThat(lastTrade.getTime()).isEqualTo(time);
    }

}
