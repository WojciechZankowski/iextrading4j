package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TradeBreakAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.math.BigDecimal;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class TradeBreakAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<Trade>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void tradeBreakAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/TradeBreakAsyncResponse.json");

        final Consumer<DeepAsyncResponse<Trade>> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new TradeBreakAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final DeepAsyncResponse<Trade> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.TRADE_BREAK);
        assertThat(response.getSeq()).isEqualTo(1L);

        final Trade data = response.getData();
        assertThat(data.getPrice()).isEqualTo(BigDecimal.valueOf(156.1));
        assertThat(data.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(data.getTradeId()).isEqualTo(517341294L);
        assertThat(data.isISO()).isFalse();
        assertThat(data.isOddLot()).isFalse();
        assertThat(data.isOutsideRegularHours()).isFalse();
        assertThat(data.isSinglePriceCross()).isFalse();
        assertThat(data.isTradeThroughExempt()).isFalse();
        assertThat(data.getTimestamp()).isEqualTo(1494619192003L);
    }
}
