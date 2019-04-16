package pl.zankowski.iextrading4j.client;


public final class IEXCloudTokenBuilder {

    private String secretToken;
    private String publishableToken;

    public IEXCloudTokenBuilder withSecretToken(final String secretToken) {
        this.secretToken = secretToken;
        return this;
    }

    public IEXCloudTokenBuilder withPublishableToken(final String publishableToken) {
        this.publishableToken = publishableToken;
        return this;
    }

    public IEXCloudToken build() {
        return new IEXCloudToken(secretToken, publishableToken);
    }
}
