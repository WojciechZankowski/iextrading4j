package pl.zankowski.iextrading4j.api.hist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class HIST {

    private final String link;
    private final String date;
    private final String feed;
    private final String version;
    private final String protocol;
    private final String size;

    @JsonCreator
    public HIST(@JsonProperty("link") String link,
                @JsonProperty("date") String date,
                @JsonProperty("feed") String feed,
                @JsonProperty("version") String version,
                @JsonProperty("protocol") String protocol,
                @JsonProperty("size") String size) {
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

    public String getDate() {
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

        if (link != null ? !link.equals(hist.link) : hist.link != null) return false;
        if (date != null ? !date.equals(hist.date) : hist.date != null) return false;
        if (feed != null ? !feed.equals(hist.feed) : hist.feed != null) return false;
        if (version != null ? !version.equals(hist.version) : hist.version != null) return false;
        if (protocol != null ? !protocol.equals(hist.protocol) : hist.protocol != null) return false;
        return size != null ? size.equals(hist.size) : hist.size == null;

    }

    @Override
    public int hashCode() {
        int result = link != null ? link.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (feed != null ? feed.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HIST{" +
                "link='" + link + '\'' +
                ", date='" + date + '\'' +
                ", feed='" + feed + '\'' +
                ", version='" + version + '\'' +
                ", protocol='" + protocol + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

}
