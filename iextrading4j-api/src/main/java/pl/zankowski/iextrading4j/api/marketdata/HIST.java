package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"link", "date", "feed", "version", "protocol", "size"})
public class HIST implements Serializable {

    private final String link;
    @JsonFormat(pattern = "yyyyMMdd")
    private final LocalDate date;
    private final String feed;
    private final String version;
    private final String protocol;
    private final String size;

    @JsonCreator
    public HIST(
            @JsonProperty("link") final String link,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("feed") final String feed,
            @JsonProperty("version") final String version,
            @JsonProperty("protocol") final String protocol,
            @JsonProperty("size") final String size) {
        this.link = link;
        this.date = date;
        this.feed = feed;
        this.version = version;
        this.protocol = protocol;
        this.size = size;
    }

    public String getLink() {
        return link;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFeed() {
        return feed;
    }

    public String getVersion() {
        return version;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HIST hist = (HIST) o;
        return Objects.equal(link, hist.link) &&
                Objects.equal(date, hist.date) &&
                Objects.equal(feed, hist.feed) &&
                Objects.equal(version, hist.version) &&
                Objects.equal(protocol, hist.protocol) &&
                Objects.equal(size, hist.size);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(link, date, feed, version, protocol, size);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("link", link)
                .add("date", date)
                .add("feed", feed)
                .add("version", version)
                .add("protocol", protocol)
                .add("size", size)
                .toString();
    }
}
