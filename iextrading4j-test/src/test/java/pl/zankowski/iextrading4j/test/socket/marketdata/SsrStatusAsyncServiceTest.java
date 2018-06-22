package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.SsrStatusAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class SsrStatusAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<SsrStatus>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void ssrStatusAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/SsrStatusAsyncResponse.json");

        final Consumer<DeepAsyncResponse<SsrStatus>> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new SsrStatusAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final DeepAsyncResponse<SsrStatus> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.SSR_STATUS);
        assertThat(response.getSeq()).isEqualTo(1L);

        final SsrStatus data = response.getData();
        assertThat(data.isSSR()).isFalse();
        assertThat(data.getDetail()).isEqualTo(" ");
        assertThat(data.getTimestamp()).isEqualTo(1529666486387L);
    }
}
