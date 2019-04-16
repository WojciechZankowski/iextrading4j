package pl.zankowski.iextrading4j.client;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class IEXCloudToken {

    private final String secretToken;
    private final String publishableToken;

    public IEXCloudToken(final String secretToken, final String publishableToken) {
        this.secretToken = secretToken;
        this.publishableToken = publishableToken;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public String getPublishableToken() {
        return publishableToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXCloudToken that = (IEXCloudToken) o;
        return Objects.equal(secretToken, that.secretToken) &&
                Objects.equal(publishableToken, that.publishableToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(secretToken, publishableToken);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("secretToken", secretToken)
                .add("publishableToken", publishableToken)
                .toString();
    }

}
