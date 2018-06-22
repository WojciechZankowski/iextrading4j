package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.LastAsyncRequestBuilder;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.math.BigDecimal;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class LastTradeAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<LastTrade> dataCaptor = ArgumentCaptor.forClass(LastTrade.class);

    @Test
    public void lastTradeAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/LastTradeAsyncResponse.json");

        final Consumer<LastTrade> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new LastAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final LastTrade response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getPrice()).usingComparator(BigDecimal::compareTo).isEqualTo(BigDecimal.valueOf(185.8350));
        assertThat(response.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(response.getTime()).isEqualTo(1529689336332L);
    }
}
