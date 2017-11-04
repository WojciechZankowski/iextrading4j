package pl.zankowski.iextrading4j.client.endpoint.marketdata.tops;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.request.TOPSRequest;
import pl.zankowski.iextrading4j.client.endpoint.util.PathUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Wojciech Zankowski
 */
public class TOPSEndpointImpl implements TOPSEndpoint {

    public static final String TOPS_PATH = "tops";
    public static final String LAST_TRADE_PATH = "last";

    public static final String SYMBOL_QUERY_PARAM = "symbols";
    public static final String SYMBOL_DELIMITER = ",";

    private final Client restClient;
    private final UriBuilder baseApiUrl;

    public TOPSEndpointImpl(Client restClient, UriBuilder baseApiUrl) {
        this.restClient = restClient;
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public TOPS[] requestTOPS(final TOPSRequest topsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, TOPS_PATH);
        webTarget = appendSymbolQuery(webTarget, topsRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = topsRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(TOPS[].class);
    }

    @Override
    public LastTrade[] requestLastTrades(final TOPSRequest topsRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, TOPS_PATH, LAST_TRADE_PATH);
        webTarget = appendSymbolQuery(webTarget, topsRequest.getSymbols());
        Optional<RequestFilter> requestFilterOptional = topsRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(LastTrade[].class);
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
