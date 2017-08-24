package pl.zankowski.iextrading4j.client.endpoint.marketdata.deep;

import pl.zankowski.iextrading4j.api.deep.*;
import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.deep.request.DEEPRequest;
import pl.zankowski.iextrading4j.client.endpoint.util.PathUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Wojciech Zankowski
 */
public class DEEPEndpointImpl implements DEEPEndpoint {

    public static final String DEEP_PATH = "deep";
    public static final String BOOK_PATH = "book";
    public static final String TRADES_PATH = "trades";
    public static final String SYSTEM_EVENT_PATH = "system-event";
    public static final String TRADING_STATUS_PATH = "trading-status";
    public static final String OP_HALT_STATUS = "op-halt-status";
    public static final String SSR_STATUS = "ssr-status";
    public static final String SECURITY_EVENT = "security-event";
    public static final String TRADE_BREAKS = "trade-breaks";

    public static final String SYMBOL_QUERY_PARAM = "symbols";
    public static final String SYMBOL_DELIMITER = ",";

    private final Client restClient;
    private final UriBuilder baseApiUrl;

    public DEEPEndpointImpl(Client restClient, UriBuilder baseApiUrl) {
        this.restClient = restClient;
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public DEEP requestDEEP(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(DEEP.class);
    }

    @Override
    public Map<String, Book> requestBook(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, BOOK_PATH);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<HashMap<String, Book>>() {});
    }

    @Override
    public Map<String, Trade[]> requestTrades(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, TRADES_PATH);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<HashMap<String, Trade[]>>() {});
    }

    @Override
    public SystemEvent requestSystemEvent(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, SYSTEM_EVENT_PATH);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(SystemEvent.class);
    }

    @Override
    public Map<String, TradingStatus> requestTradingStatus(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, TRADING_STATUS_PATH);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<HashMap<String, TradingStatus>>() {});
    }

    @Override
    public Map<String, OpHaltStatus> requestOpHaltStatus(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, OP_HALT_STATUS);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<HashMap<String, OpHaltStatus>>() {});
    }

    @Override
    public Map<String, SsrStatus> requestSsrStatus(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, SSR_STATUS);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<HashMap<String, SsrStatus>>() {});
    }

    @Override
    public Map<String, SecurityEvent> requestSecurityEvent(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, SECURITY_EVENT);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<HashMap<String, SecurityEvent>>() {});
    }

    @Override
    public Map<String, Trade[]> requestTradeBreaks(DEEPRequest deepRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, DEEP_PATH, TRADE_BREAKS);
        webTarget = appendSymbolQuery(webTarget, deepRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = deepRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<HashMap<String, Trade[]>>() {});
    }

    private WebTarget appendSymbolQuery(WebTarget webTarget, String[] symbols) {
        if (symbols.length != 0) {
            webTarget = PathUtil.appendQuery(webTarget, SYMBOL_QUERY_PARAM, formatQuerySymbolsParameter(symbols));
        }
        return webTarget;
    }

    private String formatQuerySymbolsParameter(String[] symbols) {
        return Arrays.stream(symbols).collect(Collectors.joining(SYMBOL_DELIMITER));
    }

}
