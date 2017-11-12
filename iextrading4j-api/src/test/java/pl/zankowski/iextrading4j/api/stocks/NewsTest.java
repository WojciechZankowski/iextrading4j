package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final LocalDateTime datetime = fixture.create(LocalDateTime.class);
        final String headline = fixture.create(String.class);
        final String source = fixture.create(String.class);
        final String url = fixture.create(String.class);
        final String summary = fixture.create(String.class);
        final String related = fixture.create(String.class);

        final News news = new News(datetime, headline, source, url, summary, related);

        assertThat(news.getDatetime()).isEqualTo(datetime);
        assertThat(news.getHeadline()).isEqualTo(headline);
        assertThat(news.getSource()).isEqualTo(source);
        assertThat(news.getUrl()).isEqualTo(url);
        assertThat(news.getSummary()).isEqualTo(summary);
        assertThat(news.getRelated()).isEqualTo(related);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(News.class)
                .usingGetClass()
                .verify();
    }

}
