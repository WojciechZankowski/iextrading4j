package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"url"})
public class Logo implements Serializable {

    private final String url;

    @JsonCreator
    public Logo(@JsonProperty("url") final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logo logo = (Logo) o;
        return Objects.equal(url, logo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("url", url)
                .toString();
    }
}
