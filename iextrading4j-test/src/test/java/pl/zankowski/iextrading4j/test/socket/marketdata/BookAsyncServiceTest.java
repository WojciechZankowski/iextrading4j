package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.BookEntry;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.BookAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.math.BigDecimal;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class BookAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<Book>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void bookAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/BookAsyncResponse.json");

        final Consumer<DeepAsyncResponse<Book>> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new BookAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final DeepAsyncResponse<Book> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.BOOK);
        assertThat(response.getSeq()).isEqualTo(5458L);

        final Book data = response.getData();
        final BookEntry bid = data.getBids().get(0);
        assertThat(bid.getPrice()).isEqualTo(BigDecimal.valueOf(185.76));
        assertThat(bid.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(bid.getTimestamp()).isEqualTo(1529689655974L);

        final BookEntry ask = data.getAsks().get(0);
        assertThat(ask.getPrice()).isEqualTo(BigDecimal.valueOf(190.34));
        assertThat(ask.getSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(ask.getTimestamp()).isEqualTo(1529688635926L);
    }
}
