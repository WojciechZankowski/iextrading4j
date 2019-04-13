package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.client.IEXCloudToken;

public class RestClientMetadata {

    private final String url;
    private final IEXCloudToken token;

    public RestClientMetadata(final String url, final IEXCloudToken token) {
        this.url = url;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public IEXCloudToken getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestClientMetadata that = (RestClientMetadata) o;
        return Objects.equal(url, that.url) &&
                Objects.equal(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url, token);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("url", url)
                .add("token", token)
                .toString();
    }

}
