package pl.zankowski.iextrading4j.client.endpoint.marketdata.hist;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.hist.HIST;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.hist.request.HISTRequest;
import pl.zankowski.iextrading4j.client.endpoint.util.PathUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author Wojciech Zankowski
 */
public class HISTEndpointImpl implements HISTEndpoint {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static final String HIST_PATH = "hist";

    public static final String DATE_QUERY_PARAM = "date";

    private final Client restClient;
    private final UriBuilder baseApiUrl;

    public HISTEndpointImpl(Client restClient, UriBuilder baseApiUrl) {
        this.restClient = restClient;
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public HIST[] requestHIST(HISTRequest histRequest) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, HIST_PATH);
        Optional<LocalDate> dateOptional = histRequest.getDate();
        if (dateOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, DATE_QUERY_PARAM, formatQueryDateParameter(dateOptional.get()));
        }
        Optional<RequestFilter> requestFilterOptional = histRequest.getRequestFilter();
        if (requestFilterOptional.isPresent()) {
            webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilterOptional.get().getColumnList());
        }
        return webTarget.request(MediaType.APPLICATION_JSON).get(HIST[].class);
    }

    private String formatQueryDateParameter(LocalDate date) {
        return DATE_FORMATTER.format(date);
    }

}
