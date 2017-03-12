package pl.zankowski.iextrading.rest.client.endpoint.market;

import pl.zankowski.iextrading.api.market.MarketVolume;
import pl.zankowski.iextrading.rest.client.IEXTradingClient;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static pl.zankowski.iextrading.rest.client.util.PathUtil.appendPaths;


/**
 * @author Wojciech Zankowski
 */
public class MarketEndpointImpl implements MarketEndpoint {

    public static final String MARKET_PATH = "market";

    private final IEXTradingClient iexTradingClient;

    public MarketEndpointImpl(IEXTradingClient iexTradingClient) {
        this.iexTradingClient = iexTradingClient;
    }

    @Override
    public MarketVolume[] requestMarketVolume() {
        WebTarget webTarget = iexTradingClient.getRESTClient().target(iexTradingClient.defaultAPIurl());
        webTarget = appendPaths(webTarget, MARKET_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(MarketVolume[].class);
    }

}
