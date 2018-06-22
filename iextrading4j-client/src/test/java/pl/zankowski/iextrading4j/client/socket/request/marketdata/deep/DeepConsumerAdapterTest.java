package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import com.flextrade.jfixture.JFixture;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.exception.IEXTradingException;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class DeepConsumerAdapterTest {

    private static final String TEST_SYMBOL = "IBM";
    private static final Long SEQ = 1L;

    private final JFixture fixture = new JFixture();

    private DeepConsumerAdapter consumerAdapter;

    @Before
    public void setUp() {
        consumerAdapter = spy(new DeepConsumerAdapter());
    }

    @Test
    public void shouldRedirectToTradingStatusMethod() {
        final TradingStatus data = fixture.create(TradingStatus.class);
        final DeepAsyncResponse<TradingStatus> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.TRADING_STATUS.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptTradingStatus(any());
    }

    @Test
    public void shouldRedirectToAuctionMethod() {
        final Auction data = fixture.create(Auction.class);
        final DeepAsyncResponse<Auction> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.AUCTION.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptAuction(any());
    }

    @Test
    public void shouldRedirectToOpHaltStatusMethod() {
        final OpHaltStatus data = fixture.create(OpHaltStatus.class);
        final DeepAsyncResponse<OpHaltStatus> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.OP_HALT_STATUS.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptOpHaltStatus(any());
    }


    @Test
    public void shouldRedirectToSsrStatusMethod() {
        final SsrStatus data = fixture.create(SsrStatus.class);
        final DeepAsyncResponse<SsrStatus> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.SSR_STATUS.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptSsrStatus(any());
    }

    @Test
    public void shouldRedirectToSecurityEventMethod() {
        final SecurityEvent data = fixture.create(SecurityEvent.class);
        final DeepAsyncResponse<SecurityEvent> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.SECURITY_EVENT.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptSecurityEvent(any());
    }

    @Test
    public void shouldRedirectToTradeBreakMethod() {
        final Trade data = fixture.create(Trade.class);
        final DeepAsyncResponse<Trade> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.TRADE_BREAK.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptTradeBreak(any());
    }

    @Test
    public void shouldRedirectToTradesMethod() {
        final Trade data = fixture.create(Trade.class);
        final DeepAsyncResponse<Trade> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.TRADES.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptTrades(any());
    }

    @Test
    public void shouldRedirectToBookMethod() {
        final Book data = fixture.create(Book.class);
        final DeepAsyncResponse<Book> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.BOOK.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptBook(any());
    }

    @Test
    public void shouldRedirectToSystemEventMethod() {
        final SystemEvent data = fixture.create(SystemEvent.class);
        final DeepAsyncResponse<SystemEvent> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.SYSTEM_EVENT.getName(), data, SEQ);

        consumerAdapter.accept(response);

        verify(consumerAdapter).acceptSystemEvent(any());
    }

    @Test(expected = IEXTradingException.class)
    public void shouldThrowAnExceptionForUnknownMessageType() {
        final SystemEvent data = fixture.create(SystemEvent.class);
        final DeepAsyncResponse<SystemEvent> response = new DeepAsyncResponse<>(TEST_SYMBOL,
                DeepMessageType.UNKNOWN.getName(), data, SEQ);

        consumerAdapter.accept(response);
    }

}
