package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class DeepAsyncResponseTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final DeepMessageType messageType = fixture.create(DeepMessageType.class);
        final SsrStatus deepResult = fixture.create(SsrStatus.class);
        final Long seq = fixture.create(Long.class);

        final DeepAsyncResponse<SsrStatus> response = new DeepAsyncResponse<>(symbol, messageType.getName(),
                deepResult, seq);

        assertThat(response.getSymbol()).isEqualTo(symbol);
        assertThat(response.getMessageType()).isEqualTo(messageType);
        assertThat(response.getData()).isEqualTo(deepResult);
        assertThat(response.getSeq()).isEqualTo(seq);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(DeepAsyncResponse.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        final String symbol = fixture.create(String.class);
        final DeepMessageType messageType = fixture.create(DeepMessageType.class);
        final SsrStatus deepResult = fixture.create(SsrStatus.class);
        final Long seq = fixture.create(Long.class);

        final DeepAsyncResponse<SsrStatus> response = new DeepAsyncResponse<>(symbol, messageType.getName(),
                deepResult, seq);

        ToStringVerifier.forObject(response)
                .verify();
    }

}
