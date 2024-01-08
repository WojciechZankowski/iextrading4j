package pl.zankowski.iextrading4j.client.sse.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.ws.rs.client.Client;

public class SseClient {

    private final Client client;
    private final SseClientMetadata sseClientMetadata;

    public SseClient(final Client client, final SseClientMetadata sseClientMetadata) {
        this.client = client;
        this.sseClientMetadata = sseClientMetadata;
    }

    public Client getClient() {
        return client;
    }

    public SseClientMetadata getSseClientMetadata() {
        return sseClientMetadata;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SseClient sseClient = (SseClient) o;
        return Objects.equal(client, sseClient.client) &&
                Objects.equal(sseClientMetadata, sseClient.sseClientMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(client, sseClientMetadata);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("client", client)
                .add("sseClientMetadata", sseClientMetadata)
                .toString();
    }

}
