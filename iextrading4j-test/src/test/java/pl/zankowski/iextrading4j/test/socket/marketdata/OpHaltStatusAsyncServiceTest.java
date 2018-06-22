package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.OpHaltStatusAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class OpHaltStatusAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<OpHaltStatus>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void opHaltStatusAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/OpHaltStatusAsyncResponse.json");

        final Consumer<DeepAsyncResponse<OpHaltStatus>> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new OpHaltStatusAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final DeepAsyncResponse<OpHaltStatus> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.OP_HALT_STATUS);
        assertThat(response.getSeq()).isEqualTo(1L);

        final OpHaltStatus data = response.getData();
        assertThat(data.isHalted()).isFalse();
        assertThat(data.getTimestamp()).isEqualTo(1529666486387L);
    }
}
