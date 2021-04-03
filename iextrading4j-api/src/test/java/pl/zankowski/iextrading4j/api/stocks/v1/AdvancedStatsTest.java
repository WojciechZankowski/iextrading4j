package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvancedStatsTest {

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
        final BigDecimal totalCash = fixture.create(BigDecimal.class);
        final BigDecimal currentDebt = fixture.create(BigDecimal.class);
        final BigDecimal revenue = fixture.create(BigDecimal.class);
        final BigDecimal grossProfit = fixture.create(BigDecimal.class);
        final BigDecimal totalRevenue = fixture.create(BigDecimal.class);
        final BigDecimal ebitda = fixture.create(BigDecimal.class);
        final BigDecimal revenuePerShare = fixture.create(BigDecimal.class);
        final BigDecimal revenuePerEmployee = fixture.create(BigDecimal.class);
        final BigDecimal debtToEquity = fixture.create(BigDecimal.class);
        final BigDecimal profitMargin = fixture.create(BigDecimal.class);
        final BigDecimal enterpriseValue = fixture.create(BigDecimal.class);
        final BigDecimal enterpriseValueToRevenue = fixture.create(BigDecimal.class);
        final BigDecimal priceToSales = fixture.create(BigDecimal.class);
        final BigDecimal priceToBook = fixture.create(BigDecimal.class);
        final BigDecimal forwardPERatio = fixture.create(BigDecimal.class);
        final BigDecimal pegRatio = fixture.create(BigDecimal.class);
        final BigDecimal peHigh = fixture.create(BigDecimal.class);
        final BigDecimal peLow = fixture.create(BigDecimal.class);
        final LocalDate week52highDate = fixture.create(LocalDate.class);
        final LocalDate week52lowDate = fixture.create(LocalDate.class);
        final BigDecimal putCallRatio = fixture.create(BigDecimal.class);
        final LocalDate week52highDateSplitAdjustOnly = fixture.create(LocalDate.class);
        final LocalDate week52lowDateSplitAdjustOnly = fixture.create(LocalDate.class);

        final AdvancedStats advancedStats = new AdvancedStats(companyName, marketcap, week52high, week52low,
                week52highSplitAdjustOnly, week52highDateSplitAdjustOnly, week52lowSplitAdjustOnly,
                week52lowDateSplitAdjustOnly, week52change, sharesOutstanding, Float, symbol,
                avg10Volume, avg30Volume, day200MovingAvg, day50MovingAvg, employees, ttmEPS, ttmDividendRate,
                dividendYield, nextDividendDate, exDividendDate, nextEarningsDate, peRatio, maxChangePercent,
                year5ChangePercent, year2ChangePercent, year1ChangePercent, ytdChangePercent, month6ChangePercent,
                month3ChangePercent, month1ChangePercent, day5ChangePercent, day30ChangePercent, totalCash,
                currentDebt, revenue, grossProfit, totalRevenue, ebitda, revenuePerShare, revenuePerEmployee,
                debtToEquity, profitMargin, enterpriseValue, enterpriseValueToRevenue, priceToSales, priceToBook,
                forwardPERatio, pegRatio, beta, peHigh, peLow, week52highDate, week52lowDate, putCallRatio);

        assertThat(advancedStats.getCompanyName()).isEqualTo(companyName);
        assertThat(advancedStats.getMarketcap()).isEqualTo(marketcap);
        assertThat(advancedStats.getWeek52high()).isEqualTo(week52high);
        assertThat(advancedStats.getWeek52low()).isEqualTo(week52low);
        assertThat(advancedStats.getWeek52highSplitAdjustOnly()).isEqualTo(week52highSplitAdjustOnly);
        assertThat(advancedStats.getWeek52highDateSplitAdjustOnly()).isEqualTo(week52highDateSplitAdjustOnly);
        assertThat(advancedStats.getWeek52lowSplitAdjustOnly()).isEqualTo(week52lowSplitAdjustOnly);
        assertThat(advancedStats.getWeek52lowDateSplitAdjustOnly()).isEqualTo(week52lowDateSplitAdjustOnly);
        assertThat(advancedStats.getWeek52change()).isEqualTo(week52change);
        assertThat(advancedStats.getSharesOutstanding()).isEqualTo(sharesOutstanding);
        assertThat(advancedStats.getFloat()).isEqualTo(Float);
        assertThat(advancedStats.getSymbol()).isEqualTo(symbol);
        assertThat(advancedStats.getAvg10Volume()).isEqualTo(avg10Volume);
        assertThat(advancedStats.getAvg30Volume()).isEqualTo(avg30Volume);
        assertThat(advancedStats.getDay200MovingAvg()).isEqualTo(day200MovingAvg);
        assertThat(advancedStats.getDay50MovingAvg()).isEqualTo(day50MovingAvg);
        assertThat(advancedStats.getEmployees()).isEqualTo(employees);
        assertThat(advancedStats.getTtmEPS()).isEqualTo(ttmEPS);
        assertThat(advancedStats.getTtmDividendRate()).isEqualTo(ttmDividendRate);
        assertThat(advancedStats.getDividendYield()).isEqualTo(dividendYield);
        assertThat(advancedStats.getNextDividendDate()).isEqualTo(nextDividendDate);
        assertThat(advancedStats.getExDividendDate()).isEqualTo(exDividendDate);
        assertThat(advancedStats.getNextEarningsDate()).isEqualTo(nextEarningsDate);
        assertThat(advancedStats.getPeRatio()).isEqualTo(peRatio);
        assertThat(advancedStats.getMaxChangePercent()).isEqualTo(maxChangePercent);
        assertThat(advancedStats.getYear5ChangePercent()).isEqualTo(year5ChangePercent);
        assertThat(advancedStats.getYear2ChangePercent()).isEqualTo(year2ChangePercent);
        assertThat(advancedStats.getYear1ChangePercent()).isEqualTo(year1ChangePercent);
        assertThat(advancedStats.getYtdChangePercent()).isEqualTo(ytdChangePercent);
        assertThat(advancedStats.getMonth6ChangePercent()).isEqualTo(month6ChangePercent);
        assertThat(advancedStats.getMonth3ChangePercent()).isEqualTo(month3ChangePercent);
        assertThat(advancedStats.getMonth1ChangePercent()).isEqualTo(month1ChangePercent);
        assertThat(advancedStats.getDay5ChangePercent()).isEqualTo(day5ChangePercent);
        assertThat(advancedStats.getDay30ChangePercent()).isEqualTo(day30ChangePercent);
        assertThat(advancedStats.getTotalCash()).isEqualTo(totalCash);
        assertThat(advancedStats.getCurrentDebt()).isEqualTo(currentDebt);
        assertThat(advancedStats.getRevenue()).isEqualTo(revenue);
        assertThat(advancedStats.getGrossProfit()).isEqualTo(grossProfit);
        assertThat(advancedStats.getTotalRevenue()).isEqualTo(totalRevenue);
        assertThat(advancedStats.getEbitda()).isEqualTo(ebitda);
        assertThat(advancedStats.getRevenuePerShare()).isEqualTo(revenuePerShare);
        assertThat(advancedStats.getRevenuePerEmployee()).isEqualTo(revenuePerEmployee);
        assertThat(advancedStats.getDebtToEquity()).isEqualTo(debtToEquity);
        assertThat(advancedStats.getProfitMargin()).isEqualTo(profitMargin);
        assertThat(advancedStats.getEnterpriseValue()).isEqualTo(enterpriseValue);
        assertThat(advancedStats.getEnterpriseValueToRevenue()).isEqualTo(enterpriseValueToRevenue);
        assertThat(advancedStats.getPriceToSales()).isEqualTo(priceToSales);
        assertThat(advancedStats.getPriceToBook()).isEqualTo(priceToBook);
        assertThat(advancedStats.getForwardPERatio()).isEqualTo(forwardPERatio);
        assertThat(advancedStats.getPegRatio()).isEqualTo(pegRatio);
        assertThat(advancedStats.getBeta()).isEqualTo(beta);
        assertThat(advancedStats.getPeHigh()).isEqualTo(peHigh);
        assertThat(advancedStats.getPeLow()).isEqualTo(peLow);
        assertThat(advancedStats.getWeek52highDate()).isEqualTo(week52highDate);
        assertThat(advancedStats.getWeek52lowDate()).isEqualTo(week52lowDate);
        assertThat(advancedStats.getPutCallRatio()).isEqualTo(putCallRatio);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(AdvancedStats.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(AdvancedStats.class))
                .verify();
    }

}
