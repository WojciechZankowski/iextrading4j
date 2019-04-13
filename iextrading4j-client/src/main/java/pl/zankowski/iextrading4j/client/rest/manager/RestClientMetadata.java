package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class RestClientMetadata {

    private final String url;
    private final String publishableToken;

    public RestClientMetadata(final String url, final String publishableToken) {
        this.url = url;
        this.publishableToken = publishableToken;
    }

    public String getUrl() {
        return url;
    }

    public String getPublishableToken() {
        return publishableToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestClientMetadata that = (RestClientMetadata) o;
        return Objects.equal(url, that.url) &&
                Objects.equal(publishableToken, that.publishableToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url, publishableToken);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("url", url)
                .add("publishableToken", publishableToken)
                .toString();
    }

}
