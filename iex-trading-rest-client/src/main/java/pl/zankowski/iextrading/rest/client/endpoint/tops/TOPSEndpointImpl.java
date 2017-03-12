package pl.zankowski.iextrading.rest.client.endpoint.tops;

import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;
import pl.zankowski.iextrading.rest.client.IEXTradingClient;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.stream.Collectors;

import static pl.zankowski.iextrading.rest.client.util.PathUtil.appendPaths;
import static pl.zankowski.iextrading.rest.client.util.PathUtil.appendQuery;


/**
 * @author Wojciech Zankowski
 */
public class TOPSEndpointImpl implements TOPSEndpoint {

    private static final String TOPS_PATH = "tops";
    private static final String LAST_TRADE_PATH = "last";

    private static final String SYMBOL_QUERY_PARAM = "symbols";
    private static final String SYMBOL_DELIMITER = ",";

    private final IEXTradingClient iexTradingClient;

    public TOPSEndpointImpl(IEXTradingClient client) {
        this.iexTradingClient = client;
    }

    @Override
    public TOPS[] requestTOPS(final String... symbols) {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, TOPS_PATH);
        webTarget = appendSymbolQuery(webTarget, symbols);
        return webTarget.request(MediaType.APPLICATION_JSON).get(TOPS[].class);
    }

    @Override
    public LastTrade[] requestLastTrades(final String... symbols) {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, TOPS_PATH, LAST_TRADE_PATH);
        webTarget = appendSymbolQuery(webTarget, symbols);
        return webTarget.request(MediaType.APPLICATION_JSON).get(LastTrade[].class);
    }

    private WebTarget appendSymbolQuery(WebTarget webTarget, String[] symbols) {
        if (symbols.length != 0) {
            webTarget = appendQuery(webTarget, SYMBOL_QUERY_PARAM, formatQuerySymbolsParameter(symbols));
        }
        return webTarget;
    }

    private String formatQuerySymbolsParameter(String[] symbols) {
        return Arrays.stream(symbols).collect(Collectors.joining(SYMBOL_DELIMITER));
    }

}
