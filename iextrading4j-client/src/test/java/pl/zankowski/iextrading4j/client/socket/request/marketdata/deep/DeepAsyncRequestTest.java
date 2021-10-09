package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DeepAsyncRequestTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final Set<String> symbols = Sets.newHashSet(fixture.collections().createCollection(String.class));
        final Set<DeepChannel> channels = Sets.newHashSet(fixture.collections().createCollection(DeepChannel.class));

        final DeepAsyncRequest request = new DeepAsyncRequest(symbols, channels);

        assertThat(request.getSymbols()).isEqualTo(symbols);
        assertThat(request.getChannels()).isEqualTo(channels);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(DeepAsyncRequest.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(DeepAsyncRequest.class))
                .verify();
    }

}
