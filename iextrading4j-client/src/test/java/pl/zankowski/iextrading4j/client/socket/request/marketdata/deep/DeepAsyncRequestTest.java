package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Sets;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class DeepAsyncRequestTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Set<String> symbols = Sets.newHashSet(fixture.collections().createCollection(String.class));
        final Set<DeepChannel> channels = Sets.newHashSet(fixture.collections().createCollection(DeepChannel.class));

        final DeepAsyncRequest request = new DeepAsyncRequest(symbols, channels);

        assertThat(request.getSymbols()).isEqualTo(symbols);
        assertThat(request.getChannels()).isEqualTo(channels);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(DeepAsyncRequest.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(DeepAsyncRequest.class))
                .verify();
    }

}
