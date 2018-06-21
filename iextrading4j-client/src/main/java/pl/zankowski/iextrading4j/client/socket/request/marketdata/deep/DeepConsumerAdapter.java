package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import pl.zankowski.iextrading4j.api.exception.IEXTradingException;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.DeepResult;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;

import java.util.function.Consumer;

public class DeepConsumerAdapter implements Consumer<DeepAsyncResponse<DeepResult>> {

    @Override
    public final void accept(final DeepAsyncResponse deepAsyncResponse) {
        final DeepMessageType messageType = deepAsyncResponse.getMessageType();

        switch (messageType) {
            case TRADING_STATUS:
                acceptTradingStatus(deepAsyncResponse);
                break;
            case AUCTION:
                acceptAuction(deepAsyncResponse);
                break;
            case OP_HALT_STATUS:
                acceptOpHaltStatus(deepAsyncResponse);
                break;
            case SSR_STATUS:
                acceptSsrStatus(deepAsyncResponse);
                break;
            case SECURITY_EVENT:
                acceptSecurityEvent(deepAsyncResponse);
                break;
            case TRADE_BREAK:
                acceptTradeBreak(deepAsyncResponse);
                break;
            case TRADES:
                acceptTrades(deepAsyncResponse);
                break;
            case BOOK:
                acceptBook(deepAsyncResponse);
                break;
            case SYSTEM_EVENT:
                acceptSystemEvent(deepAsyncResponse);
                break;
            default:
                throw new IEXTradingException("Message type not supported: " + messageType);
        }
    }

    public void acceptTradingStatus(final DeepAsyncResponse<TradingStatus> tradingStatusResponse) {
    }

    public void acceptAuction(final DeepAsyncResponse<Auction> auctionResponse) {
    }

    public void acceptOpHaltStatus(final DeepAsyncResponse<OpHaltStatus> opHaltStatusResponse) {
    }

    public void acceptSsrStatus(final DeepAsyncResponse<SsrStatus> ssrStatusResponse) {
    }

    public void acceptSecurityEvent(final DeepAsyncResponse<SecurityEvent> securityEventResponse) {
    }

    public void acceptTradeBreak(final DeepAsyncResponse<Trade> tradeBreakResponse) {
    }

    public void acceptTrades(final DeepAsyncResponse<Trade> tradesResponse) {
    }

    public void acceptBook(final DeepAsyncResponse<Book> bookResponse) {
    }

    public void acceptSystemEvent(final DeepAsyncResponse<SystemEvent> systemEventResponse) {
    }

}
