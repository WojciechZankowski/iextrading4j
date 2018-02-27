package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class HISTTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String link = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final String feed = fixture.create(String.class);
        final String version = fixture.create(String.class);
        final String protocol = fixture.create(String.class);
        final String size = fixture.create(String.class);

        final HIST hist = new HIST(link, date, feed, version, protocol, size);

        assertThat(hist.getLink()).isEqualTo(link);
        assertThat(hist.getDate()).isEqualTo(date);
        assertThat(hist.getFeed()).isEqualTo(feed);
        assertThat(hist.getVersion()).isEqualTo(version);
        assertThat(hist.getProtocol()).isEqualTo(protocol);
        assertThat(hist.getSize()).isEqualTo(size);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(HIST.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(HIST.class))
                .verify();
    }

}
