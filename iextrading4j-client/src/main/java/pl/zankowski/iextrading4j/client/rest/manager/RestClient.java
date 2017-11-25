package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.ws.rs.client.Client;

public class RestClient {

    private final Client client;
    private final RestClientMetadata restClientMetadata;

    public RestClient(final Client client, final RestClientMetadata restClientMetadata) {
        this.client = client;
        this.restClientMetadata = restClientMetadata;
    }

    public Client getClient() {
        return client;
    }

    public RestClientMetadata getRestClientMetadata() {
        return restClientMetadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestClient that = (RestClient) o;
        return Objects.equal(client, that.client) &&
                Objects.equal(restClientMetadata, that.restClientMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(client, restClientMetadata);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("client", client)
                .add("restClientMetadata", restClientMetadata)
                .toString();
    }
}
