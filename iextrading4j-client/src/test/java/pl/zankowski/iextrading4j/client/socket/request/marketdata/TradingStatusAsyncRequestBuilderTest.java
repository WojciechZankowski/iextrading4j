package pl.zankowski.iextrading4j.client.socket.request.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import static org.assertj.core.api.Assertions.assertThat;

public class TradingStatusAsyncRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final String symbol = "IBM";

        final SocketRequest<DeepAsyncResponse<TradingStatus>> request = new TradingStatusAsyncRequestBuilder()
                .withSymbol(symbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/deep");

        final DeepAsyncRequest param = (DeepAsyncRequest) request.getParam();
        assertThat(param.getSymbols()).containsExactly(symbol);
        assertThat(param.getChannels()).containsExactly(DeepChannel.TRADING_STATUS);
    }

}
