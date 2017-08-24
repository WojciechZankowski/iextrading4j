package pl.zankowski.iextrading4j.client.endpoint.marketdata.deep;

import pl.zankowski.iextrading4j.api.deep.*;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.deep.request.DEEPRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wojciech Zankowski
 */
public interface DEEPEndpoint {

    DEEP requestDEEP(DEEPRequest deepRequest);

    Map<String, Book> requestBook(DEEPRequest deepRequest);

    Map<String, Trade[]> requestTrades(DEEPRequest deepRequest);

    SystemEvent requestSystemEvent(DEEPRequest deepRequest);

    Map<String, TradingStatus> requestTradingStatus(DEEPRequest deepRequest);

    Map<String, OpHaltStatus> requestOpHaltStatus(DEEPRequest deepRequest);

    Map<String, SsrStatus> requestSsrStatus(DEEPRequest deepRequest);

    Map<String, SecurityEvent> requestSecurityEvent(DEEPRequest deepRequest);

    Map<String, Trade[]> requestTradeBreaks(DEEPRequest deepRequest);

}
