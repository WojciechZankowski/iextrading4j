package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyStatsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String companyName = fixture.create(String.class);
        final BigDecimal marketcap = fixture.create(BigDecimal.class);
        final BigDecimal beta = fixture.create(BigDecimal.class);
        final BigDecimal week52high = fixture.create(BigDecimal.class);
        final BigDecimal week52low = fixture.create(BigDecimal.class);
        final BigDecimal week52change = fixture.create(BigDecimal.class);
        final BigDecimal shortInterest = fixture.create(BigDecimal.class);
        final LocalDate shortDate = fixture.create(LocalDate.class);
        final BigDecimal dividendRate = fixture.create(BigDecimal.class);
        final BigDecimal dividendYield = fixture.create(BigDecimal.class);
        final LocalDateTime exDividendDate = fixture.create(LocalDateTime.class);
        final BigDecimal latestEPS = fixture.create(BigDecimal.class);
        final LocalDate latestEPSDate = fixture.create(LocalDate.class);
        final BigDecimal sharesOutstanding = fixture.create(BigDecimal.class);
        final BigDecimal Float = fixture.create(BigDecimal.class);
        final BigDecimal returnOnEquity = fixture.create(BigDecimal.class);
        final BigDecimal consensusEPS = fixture.create(BigDecimal.class);
        final BigDecimal numberOfEstimates = fixture.create(BigDecimal.class);
        final BigDecimal EPSSurpriseDollar = fixture.create(BigDecimal.class);
        final BigDecimal EPSSurprisePercent = fixture.create(BigDecimal.class);
        final String symbol = fixture.create(String.class);
        final BigDecimal EBITDA = fixture.create(BigDecimal.class);
        final BigDecimal revenue = fixture.create(BigDecimal.class);
        final BigDecimal grossProfit = fixture.create(BigDecimal.class);
        final BigDecimal cash = fixture.create(BigDecimal.class);
        final BigDecimal debt = fixture.create(BigDecimal.class);
        final BigDecimal ttmEPS = fixture.create(BigDecimal.class);
        final BigDecimal revenuePerShare = fixture.create(BigDecimal.class);
        final BigDecimal revenuePerEmployee = fixture.create(BigDecimal.class);
        final BigDecimal peRatioHigh = fixture.create(BigDecimal.class);
        final BigDecimal peRatioLow = fixture.create(BigDecimal.class);
        final BigDecimal returnOnAssets = fixture.create(BigDecimal.class);
        final BigDecimal returnOnCapital = fixture.create(BigDecimal.class);
        final BigDecimal profitMargin = fixture.create(BigDecimal.class);
        final BigDecimal priceToSales = fixture.create(BigDecimal.class);
        final BigDecimal priceToBook = fixture.create(BigDecimal.class);
        final BigDecimal day200MovingAvg = fixture.create(BigDecimal.class);
        final BigDecimal day50MovingAvg = fixture.create(BigDecimal.class);
        final BigDecimal institutionPercent = fixture.create(BigDecimal.class);
        final BigDecimal insiderPercent = fixture.create(BigDecimal.class);
        final BigDecimal shortRatio = fixture.create(BigDecimal.class);
        final BigDecimal year5ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal year2ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal year1ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal ytdChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal month6ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal month3ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal month1ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal day5ChangePercent = fixture.create(BigDecimal.class);
        final BigDecimal day30ChangePercent = fixture.create(BigDecimal.class);

        final KeyStats keyStats = new KeyStats(companyName, marketcap, beta, week52high, week52low, week52change,
                shortInterest, shortDate, dividendRate, dividendYield, exDividendDate, latestEPS, latestEPSDate,
                sharesOutstanding, Float, returnOnEquity, consensusEPS, numberOfEstimates, EPSSurpriseDollar,
                EPSSurprisePercent, symbol, EBITDA, revenue, grossProfit, cash, debt, ttmEPS, revenuePerShare,
                revenuePerEmployee, peRatioHigh, peRatioLow, returnOnAssets, returnOnCapital, profitMargin,
                priceToSales, priceToBook, day200MovingAvg, day50MovingAvg, institutionPercent, insiderPercent,
                shortRatio, year5ChangePercent, year2ChangePercent, year1ChangePercent, ytdChangePercent,
                month6ChangePercent, month3ChangePercent, month1ChangePercent, day5ChangePercent, day30ChangePercent);

        assertThat(keyStats.getCompanyName()).isEqualTo(companyName);
        assertThat(keyStats.getMarketcap()).isEqualTo(marketcap);
        assertThat(keyStats.getBeta()).isEqualTo(beta);
        assertThat(keyStats.getWeek52high()).isEqualTo(week52high);
        assertThat(keyStats.getWeek52low()).isEqualTo(week52low);
        assertThat(keyStats.getWeek52change()).isEqualTo(week52change);
        assertThat(keyStats.getShortInterest()).isEqualTo(shortInterest);
        assertThat(keyStats.getShortDate()).isEqualTo(shortDate);
        assertThat(keyStats.getDividendRate()).isEqualTo(dividendRate);
        assertThat(keyStats.getDividendYield()).isEqualTo(dividendYield);
        assertThat(keyStats.getExDividendDate()).isEqualTo(exDividendDate);
        assertThat(keyStats.getLatestEPS()).isEqualTo(latestEPS);
        assertThat(keyStats.getLatestEPSDate()).isEqualTo(latestEPSDate);
        assertThat(keyStats.getSharesOutstanding()).isEqualTo(sharesOutstanding);
        assertThat(keyStats.getFloat()).isEqualTo(Float);
        assertThat(keyStats.getReturnOnEquity()).isEqualTo(returnOnEquity);
        assertThat(keyStats.getConsensusEPS()).isEqualTo(consensusEPS);
        assertThat(keyStats.getNumberOfEstimates()).isEqualTo(numberOfEstimates);
        assertThat(keyStats.getEPSSurpriseDollar()).isEqualTo(EPSSurpriseDollar);
        assertThat(keyStats.getEPSSurprisePercent()).isEqualTo(EPSSurprisePercent);
        assertThat(keyStats.getSymbol()).isEqualTo(symbol);
        assertThat(keyStats.getEBITDA()).isEqualTo(EBITDA);
        assertThat(keyStats.getRevenue()).isEqualTo(revenue);
        assertThat(keyStats.getGrossProfit()).isEqualTo(grossProfit);
        assertThat(keyStats.getCash()).isEqualTo(cash);
        assertThat(keyStats.getDebt()).isEqualTo(debt);
        assertThat(keyStats.getTtmEPS()).isEqualTo(ttmEPS);
        assertThat(keyStats.getRevenuePerShare()).isEqualTo(revenuePerShare);
        assertThat(keyStats.getRevenuePerEmployee()).isEqualTo(revenuePerEmployee);
        assertThat(keyStats.getPeRatioHigh()).isEqualTo(peRatioHigh);
        assertThat(keyStats.getPeRatioLow()).isEqualTo(peRatioLow);
        assertThat(keyStats.getReturnOnAssets()).isEqualTo(returnOnAssets);
        assertThat(keyStats.getReturnOnCapital()).isEqualTo(returnOnCapital);
        assertThat(keyStats.getProfitMargin()).isEqualTo(profitMargin);
        assertThat(keyStats.getPriceToSales()).isEqualTo(priceToSales);
        assertThat(keyStats.getPriceToBook()).isEqualTo(priceToBook);
        assertThat(keyStats.getDay200MovingAvg()).isEqualTo(day200MovingAvg);
        assertThat(keyStats.getDay50MovingAvg()).isEqualTo(day50MovingAvg);
        assertThat(keyStats.getInstitutionPercent()).isEqualTo(institutionPercent);
        assertThat(keyStats.getInsiderPercent()).isEqualTo(insiderPercent);
        assertThat(keyStats.getShortRatio()).isEqualTo(shortRatio);
        assertThat(keyStats.getYear5ChangePercent()).isEqualTo(year5ChangePercent);
        assertThat(keyStats.getYear2ChangePercent()).isEqualTo(year2ChangePercent);
        assertThat(keyStats.getYear1ChangePercent()).isEqualTo(year1ChangePercent);
        assertThat(keyStats.getYtdChangePercent()).isEqualTo(ytdChangePercent);
        assertThat(keyStats.getMonth6ChangePercent()).isEqualTo(month6ChangePercent);
        assertThat(keyStats.getMonth3ChangePercent()).isEqualTo(month3ChangePercent);
        assertThat(keyStats.getMonth1ChangePercent()).isEqualTo(month1ChangePercent);
        assertThat(keyStats.getDay5ChangePercent()).isEqualTo(day5ChangePercent);
        assertThat(keyStats.getDay30ChangePercent()).isEqualTo(day30ChangePercent);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(KeyStats.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(KeyStats.class))
                .verify();
    }

}
