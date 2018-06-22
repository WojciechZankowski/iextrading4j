package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TradeBreakAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TradesAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.math.BigDecimal;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class TradesAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<Trade>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void tradesAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/TradesAsyncResponse.json");

        final Consumer<DeepAsyncResponse<Trade>> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new TradesAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final DeepAsyncResponse<Trade> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.TRADES);
        assertThat(response.getSeq()).isEqualTo(2964L);

        final Trade data = response.getData();
        assertThat(data.getPrice()).isEqualTo(BigDecimal.valueOf(185.8100));
        assertThat(data.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(data.getTradeId()).isEqualTo(517936386L);
        assertThat(data.isISO()).isTrue();
        assertThat(data.isOddLot()).isFalse();
        assertThat(data.isOutsideRegularHours()).isFalse();
        assertThat(data.isSinglePriceCross()).isFalse();
        assertThat(data.isTradeThroughExempt()).isFalse();
        assertThat(data.getTimestamp()).isEqualTo(1529689623331L);
    }
}
