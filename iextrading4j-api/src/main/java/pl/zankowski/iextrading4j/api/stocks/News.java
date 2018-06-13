package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.OffsetDateTime;

@JsonPropertyOrder({"datetime", "headline", "source", "url", "summary", "related", "image"})
public class News implements Serializable {

    private final OffsetDateTime datetime;
    private final String headline;
    private final String source;
    private final String url;
    private final String summary;
    private final String related;
    private final String image;

    @JsonCreator
    public News(
            @JsonProperty("datetime") final OffsetDateTime datetime,
            @JsonProperty("headline") final String headline,
            @JsonProperty("source") final String source,
            @JsonProperty("url") final String url,
            @JsonProperty("summary") final String summary,
            @JsonProperty("related") final String related,
            @JsonProperty("image") final String image) {
        this.datetime = datetime;
        this.headline = headline;
        this.source = source;
        this.url = url;
        this.summary = summary;
        this.related = related;
        this.image = image;
    }

    public OffsetDateTime getDatetime() {
        return datetime;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public String getSummary() {
        return summary;
    }

    public String getRelated() {
        return related;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equal(datetime, news.datetime) &&
                Objects.equal(headline, news.headline) &&
                Objects.equal(source, news.source) &&
                Objects.equal(url, news.url) &&
                Objects.equal(summary, news.summary) &&
                Objects.equal(related, news.related) &&
                Objects.equal(image, news.image);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(datetime, headline, source, url, summary, related, image);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("datetime", datetime)
                .add("headline", headline)
                .add("source", source)
                .add("url", url)
                .add("summary", summary)
                .add("related", related)
                .add("image", image)
                .toString();
    }
}
