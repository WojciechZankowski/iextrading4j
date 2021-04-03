package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final Long datetime = fixture.create(Long.class);
        final String headline = fixture.create(String.class);
        final String source = fixture.create(String.class);
        final String url = fixture.create(String.class);
        final String summary = fixture.create(String.class);
        final String related = fixture.create(String.class);
        final String image = fixture.create(String.class);
        final String lang = fixture.create(String.class);
        final Boolean hasPaywall = fixture.create(Boolean.class);
        final String symbol = fixture.create(String.class);

        final News news = new News(datetime, headline, source, url, summary, related, image, lang, hasPaywall, symbol);

        assertThat(news.getDatetime()).isEqualTo(datetime);
        assertThat(news.getHeadline()).isEqualTo(headline);
        assertThat(news.getSource()).isEqualTo(source);
        assertThat(news.getUrl()).isEqualTo(url);
        assertThat(news.getSummary()).isEqualTo(summary);
        assertThat(news.getRelated()).isEqualTo(related);
        assertThat(news.getImage()).isEqualTo(image);
        assertThat(news.getLang()).isEqualTo(lang);
        assertThat(news.getHasPaywall()).isEqualTo(hasPaywall);
        assertThat(news.getSymbol()).isEqualTo(symbol);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(News.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(News.class))
                .verify();
    }


}
