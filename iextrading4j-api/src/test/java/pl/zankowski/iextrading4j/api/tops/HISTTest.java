package pl.zankowski.iextrading4j.api.tops;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.api.tops.builder.HISTDataBuilder.defaultHIST;

/**
 * @author Wojciech Zankowski
 */
public class HISTTest {

    @Test
    public void shouldSuccessfullyCreateEmptyObject() {
        HIST hist = new HIST();

        assertThat(hist.getLink()).isNull();
        assertThat(hist.getDate()).isNull();
        assertThat(hist.getFeed()).isNull();
        assertThat(hist.getVersion()).isNull();
        assertThat(hist.getProtocol()).isNull();
        assertThat(hist.getSize()).isNull();
    }

    @Test
    public void shouldSuccessfullyCreateHIST() {
        final String link = "https://www.googleapis.co…95063270068421&alt=media";
        final String date = "20170515";
        final String feed = "DEEP";
        final String version = "1.0";
        final String protocol = "IEXTP1";
        final String size = "640265166";

        HIST hist = new HIST(link, date, feed, version, protocol, size);

        assertHIST(hist, link, date, feed, version, protocol, size);
    }

    @Test
    public void shouldSuccessfullySetValuesIntoEmptyHIST() {
        final String link = "https://www.googleapis.co…95063270068421&alt=media";
        final String date = "20170515";
        final String feed = "DEEP";
        final String version = "1.0";
        final String protocol = "IEXTP1";
        final String size = "640265166";

        HIST hist = new HIST();
        hist.setLink(link);
        hist.setDate(date);
        hist.setFeed(feed);
        hist.setVersion(version);
        hist.setProtocol(protocol);
        hist.setSize(size);

        assertHIST(hist, link, date, feed, version, protocol, size);
    }

    @Test
    public void shouldSuccessfullyEqualTwoHISTs() {
        HIST hist_1 = defaultHIST();
        HIST hist_2 = defaultHIST();

        assertThat(hist_1.equals(hist_2)).isTrue();
        assertThat(hist_1.hashCode()).isEqualTo(hist_2.hashCode());
    }

    private void assertHIST(HIST hist, String link, String date, String feed, String version, String protocol, String size) {
        assertThat(hist.getLink()).isEqualTo(link);
        assertThat(hist.getDate()).isEqualTo(date);
        assertThat(hist.getFeed()).isEqualTo(feed);
        assertThat(hist.getVersion()).isEqualTo(version);
        assertThat(hist.getProtocol()).isEqualTo(protocol);
        assertThat(hist.getSize()).isEqualTo(size);
    }

}
