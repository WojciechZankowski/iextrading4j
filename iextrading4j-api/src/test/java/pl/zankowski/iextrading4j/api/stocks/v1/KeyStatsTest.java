package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyStatsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String companyName = fixture.create(String.class);
        final BigDecimal marketcap = fixture.create(BigDecimal.class);
        final BigDecimal week52high = fixture.create(BigDecimal.class);
        final BigDecimal week52low = fixture.create(BigDecimal.class);
        final BigDecimal week52highSplitAdjustOnly = fixture.create(BigDecimal.class);
        final BigDecimal week52lowSplitAdjustOnly = fixture.create(BigDecimal.class);
        final BigDecimal week52change = fixture.create(BigDecimal.class);
        final BigDecimal sharesOutstanding = fixture.create(BigDecimal.class);
        final BigDecimal Float = fixture.create(BigDecimal.class);
        final String symbol = fixture.create(String.class);
        final BigDecimal avg10Volume = fixture.create(BigDecimal.class);
        final BigDecimal avg30Volume = fixture.create(BigDecimal.class);
        final BigDecimal day200MovingAvg = fixture.create(BigDecimal.class);
        final BigDecimal day50MovingAvg = fixture.create(BigDecimal.class);
        final BigDecimal employees = fixture.create(BigDecimal.class);
        final BigDecimal ttmEPS = fixture.create(BigDecimal.class);
        final BigDecimal ttmDividendRate = fixture.create(BigDecimal.class);
        final BigDecimal dividendYield = fixture.create(BigDecimal.class);
        final LocalDate nextDividendDate = fixture.create(LocalDate.class);
        final LocalDate exDividendDate = fixture.create(LocalDate.class);
        final LocalDate nextEarningsDate = fixture.create(LocalDate.class);
        final BigDecimal peRatio = fixture.create(BigDecimal.class);
        final BigDecimal maxChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal year5ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal year2ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal year1ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal ytdChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal month6ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal month3ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal month1ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal day5ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal day30ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal beta = fixture.create(BigDecimal.class);

        final KeyStats keyStats = new KeyStats(companyName, marketcap, week52high, week52low,
                week52highSplitAdjustOnly, week52lowSplitAdjustOnly, week52change, sharesOutstanding, Float,
                symbol, avg10Volume, avg30Volume, day200MovingAvg, day50MovingAvg, employees, ttmEPS, ttmDividendRate,
                dividendYield, nextDividendDate, exDividendDate, nextEarningsDate, peRatio, maxChangePercent,
                year5ChangePercent, year2ChangePercent, year1ChangePercent, ytdChangePercent, month6ChangePercent,
                month3ChangePercent, month1ChangePercent, day5ChangePercent, day30ChangePercent, beta);

        assertThat(keyStats.getCompanyName()).isEqualTo(companyName);
        assertThat(keyStats.getMarketcap()).isEqualTo(marketcap);
        assertThat(keyStats.getWeek52high()).isEqualTo(week52high);
        assertThat(keyStats.getWeek52low()).isEqualTo(week52low);
        assertThat(keyStats.getWeek52highSplitAdjustOnly()).isEqualTo(week52highSplitAdjustOnly);
        assertThat(keyStats.getWeek52lowSplitAdjustOnly()).isEqualTo(week52lowSplitAdjustOnly);
        assertThat(keyStats.getWeek52change()).isEqualTo(week52change);
        assertThat(keyStats.getSharesOutstanding()).isEqualTo(sharesOutstanding);
        assertThat(keyStats.getFloat()).isEqualTo(Float);
        assertThat(keyStats.getSymbol()).isEqualTo(symbol);
        assertThat(keyStats.getAvg10Volume()).isEqualTo(avg10Volume);
        assertThat(keyStats.getAvg30Volume()).isEqualTo(avg30Volume);
        assertThat(keyStats.getDay200MovingAvg()).isEqualTo(day200MovingAvg);
        assertThat(keyStats.getDay50MovingAvg()).isEqualTo(day50MovingAvg);
        assertThat(keyStats.getEmployees()).isEqualTo(employees);
        assertThat(keyStats.getTtmEPS()).isEqualTo(ttmEPS);
        assertThat(keyStats.getTtmDividendRate()).isEqualTo(ttmDividendRate);
        assertThat(keyStats.getDividendYield()).isEqualTo(dividendYield);
        assertThat(keyStats.getNextDividendDate()).isEqualTo(nextDividendDate);
        assertThat(keyStats.getExDividendDate()).isEqualTo(exDividendDate);
        assertThat(keyStats.getNextEarningsDate()).isEqualTo(nextEarningsDate);
        assertThat(keyStats.getPeRatio()).isEqualTo(peRatio);
        assertThat(keyStats.getMaxChangePercent()).isEqualTo(maxChangePercent);
        assertThat(keyStats.getYear5ChangePercent()).isEqualTo(year5ChangePercent);
        assertThat(keyStats.getYear2ChangePercent()).isEqualTo(year2ChangePercent);
        assertThat(keyStats.getYear1ChangePercent()).isEqualTo(year1ChangePercent);
        assertThat(keyStats.getYtdChangePercent()).isEqualTo(ytdChangePercent);
        assertThat(keyStats.getMonth6ChangePercent()).isEqualTo(month6ChangePercent);
        assertThat(keyStats.getMonth3ChangePercent()).isEqualTo(month3ChangePercent);
        assertThat(keyStats.getMonth1ChangePercent()).isEqualTo(month1ChangePercent);
        assertThat(keyStats.getDay5ChangePercent()).isEqualTo(day5ChangePercent);
        assertThat(keyStats.getDay30ChangePercent()).isEqualTo(day30ChangePercent);
        assertThat(keyStats.getBeta()).isEqualTo(beta);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(KeyStats.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(KeyStats.class))
                .verify();
    }

}
