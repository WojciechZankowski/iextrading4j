package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class News {

    private final String datetime;
    private final String headline;
    private final String source;
    private final String url;
    private final String summary;
    private final String related;

    @JsonCreator
    public News(@JsonProperty("datetime") String datetime,
                @JsonProperty("headline") String headline,
                @JsonProperty("source") String source,
                @JsonProperty("url") String url,
                @JsonProperty("summary") String summary,
                @JsonProperty("related") String related) {
        this.datetime = datetime;
        this.headline = headline;
        this.source = source;
        this.url = url;
        this.summary = summary;
        this.related = related;
    }

    public String getDatetime() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (datetime != null ? !datetime.equals(news.datetime) : news.datetime != null) return false;
        if (headline != null ? !headline.equals(news.headline) : news.headline != null) return false;
        if (source != null ? !source.equals(news.source) : news.source != null) return false;
        if (url != null ? !url.equals(news.url) : news.url != null) return false;
        if (summary != null ? !summary.equals(news.summary) : news.summary != null) return false;
        return related != null ? related.equals(news.related) : news.related == null;

    }

    @Override
    public int hashCode() {
        int result = datetime != null ? datetime.hashCode() : 0;
        result = 31 * result + (headline != null ? headline.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (related != null ? related.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "datetime='" + datetime + '\'' +
                ", headline='" + headline + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", summary='" + summary + '\'' +
                ", related='" + related + '\'' +
                '}';
    }
    
}
