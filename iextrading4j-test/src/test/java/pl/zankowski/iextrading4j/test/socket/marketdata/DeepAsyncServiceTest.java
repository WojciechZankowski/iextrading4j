package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.DeepAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepConsumerAdapter;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class DeepAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<TradingStatus>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void deepAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/TradingStatusAsyncResponse.json");

        final DeepConsumerAdapter consumer = spy(DeepConsumerAdapter.class);

        iexTradingClient.subscribe(new DeepAsyncRequestBuilder()
                .addChannel(DeepChannel.TRADING_STATUS)
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).acceptTradingStatus(dataCaptor.capture());

        final DeepAsyncResponse<TradingStatus> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.TRADING_STATUS);
        assertThat(response.getSeq()).isEqualTo(1L);

        final TradingStatus data = response.getData();
        assertThat(data.getStatus()).isEqualTo(TradingStatusType.TRADING_ON_IEX);
        assertThat(data.getReason()).isEqualTo(TradingStatusReasonType.UNKNOWN);
        assertThat(data.getTimestamp()).isEqualTo(1529666486387L);
    }
}
