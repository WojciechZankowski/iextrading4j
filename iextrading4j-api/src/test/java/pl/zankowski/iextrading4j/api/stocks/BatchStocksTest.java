package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BatchStocksTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Book book = fixture.create(Book.class);
        final List<Chart> chart = Lists.newArrayList(fixture.collections().createCollection(Chart.class));
        final Company company = fixture.create(Company.class);
        final DelayedQuote delayedQuote = fixture.create(DelayedQuote.class);
        final List<Dividends> dividends = Lists.newArrayList(fixture.collections()
                .createCollection(Dividends.class));
        final Earnings earnings = fixture.create(Earnings.class);
        final List<EffectiveSpread> effectiveSpread = Lists.newArrayList(fixture.collections()
                .createCollection(EffectiveSpread.class));
        final Financials financials = fixture.create(Financials.class);
        final List<ThresholdSecurities> thresholdSecurities = Lists.newArrayList(fixture.collections()
                .createCollection(ThresholdSecurities.class));
        final List<ShortInterest> shortInterest = Lists.newArrayList(fixture.collections()
                .createCollection(ShortInterest.class));
        final KeyStats keyStats = fixture.create(KeyStats.class);
        final List<LargestTrade> largestTrades = Lists.newArrayList(fixture.collections()
                .createCollection(LargestTrade.class));
        final Logo logo = fixture.create(Logo.class);
        final List<News> news = Lists.newArrayList(fixture.collections().createCollection(News.class));
        final Ohlc ohlc = fixture.create(Ohlc.class);
        final List<String> peers = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final BarData previous = fixture.create(BarData.class);
        final BigDecimal price = fixture.create(BigDecimal.class);
        final Quote quote = fixture.create(Quote.class);
        final Relevant relevant = fixture.create(Relevant.class);
        final List<Split> splits = Lists.newArrayList(fixture.collections().createCollection(Split.class));
        final List<VenueVolume> venueVolume = Lists.newArrayList(fixture.collections()
                .createCollection(VenueVolume.class));

        final BatchStocks batchStocks = new BatchStocks(book, chart, company, delayedQuote, dividends, earnings,
                effectiveSpread, financials, thresholdSecurities, shortInterest, keyStats, largestTrades, logo,
                news, ohlc, peers, previous, price, quote, relevant, splits, venueVolume);

        assertThat(batchStocks.getBook()).isEqualTo(book);
        assertThat(batchStocks.getChart()).isEqualTo(chart);
        assertThat(batchStocks.getCompany()).isEqualTo(company);
        assertThat(batchStocks.getDelayedQuote()).isEqualTo(delayedQuote);
        assertThat(batchStocks.getDividends()).isEqualTo(dividends);
        assertThat(batchStocks.getEarnings()).isEqualTo(earnings);
        assertThat(batchStocks.getEffectiveSpread()).isEqualTo(effectiveSpread);
        assertThat(batchStocks.getFinancials()).isEqualTo(financials);
        assertThat(batchStocks.getThresholdSecurities()).isEqualTo(thresholdSecurities);
        assertThat(batchStocks.getShortInterest()).isEqualTo(shortInterest);
        assertThat(batchStocks.getKeyStats()).isEqualTo(keyStats);
        assertThat(batchStocks.getLargestTrades()).isEqualTo(largestTrades);
        assertThat(batchStocks.getLogo()).isEqualTo(logo);
        assertThat(batchStocks.getNews()).isEqualTo(news);
        assertThat(batchStocks.getOhlc()).isEqualTo(ohlc);
        assertThat(batchStocks.getPeers()).isEqualTo(peers);
        assertThat(batchStocks.getPrevious()).isEqualTo(previous);
        assertThat(batchStocks.getPrice()).isEqualTo(price);
        assertThat(batchStocks.getQuote()).isEqualTo(quote);
        assertThat(batchStocks.getRelevant()).isEqualTo(relevant);
        assertThat(batchStocks.getSplits()).isEqualTo(splits);
        assertThat(batchStocks.getVenueVolume()).isEqualTo(venueVolume);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(BatchStocks.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(BatchStocks.class))
                .verify();
    }

}
