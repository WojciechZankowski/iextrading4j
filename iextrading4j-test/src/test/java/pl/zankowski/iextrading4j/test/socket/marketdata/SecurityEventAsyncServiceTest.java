package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEventType;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.SecurityEventAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class SecurityEventAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<SecurityEvent>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void securityEventAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/SecurityEventAsyncResponse.json");

        final Consumer<DeepAsyncResponse<SecurityEvent>> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new SecurityEventAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final DeepAsyncResponse<SecurityEvent> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.SECURITY_EVENT);
        assertThat(response.getSeq()).isEqualTo(2L);

        final SecurityEvent data = response.getData();
        assertThat(data.getSecurityEvent()).isEqualTo(SecurityEventType.MarketClose);
        assertThat(data.getTimestamp()).isEqualTo(1529611200000L);
    }

}
