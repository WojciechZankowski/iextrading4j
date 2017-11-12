package pl.zankowski.iextrading4j.client.rest.manager;

import pl.zankowski.iextrading4j.client.mapper.IEXTradingMapperContextResolver;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class RestManager {

    public static final String API_URL = "https://api.iextrading.com/1.0";

    private final RestClient restClient;

    public RestManager() {
        this.restClient = new RestClient(ClientBuilder.newClient(), new RestClientMetadata());
        this.restClient.getClient().register(IEXTradingMapperContextResolver.class);
    }

    public <R> RestResponse<R> executeRequest(final RestRequest<R> restRequest) {
        final String url = createURL(restRequest);

        final Invocation.Builder invocationBuilder = restClient.getClient().target(url)
                .request(MediaType.APPLICATION_JSON);

        Response response = null;

        try {

            switch (restRequest.getMethodType()) {
                case GET:
                    response = invocationBuilder.get();
                    break;
                default:
                    throw new IllegalStateException("Method Type not supported.");
            }

            return new RestResponseBuilder<R>()
                    .withMessage(response.getStatusInfo().getReasonPhrase())
                    .withResponse(response.readEntity(restRequest.getResponseType()))
                    .build();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    private <R> String createURL(final RestRequest<R> restRequest) {
        return new StringBuilder()
                .append(getServicePath())
                .append(createPath(restRequest.getPath(), restRequest.getPathParams()))
                .append(createQueryParameters(restRequest.getQueryParams()))
                .toString();
    }

    private String createPath(final String originalPath, final Map<String, String> pathParams) {
        String path = originalPath;
        for (final Map.Entry<String, String> entry : pathParams.entrySet()) {
            path = path.replaceFirst("\\{" + entry.getKey() + "\\}", entry.getValue());
        }

        return path;
    }

    private String createQueryParameters(final Map<String, String> queryParams) {
        if (queryParams.isEmpty()) {
            return "";
        }

        return queryParams.entrySet().stream()
                .map(this::createQueryParam)
                .collect(joining("&", "?", ""));
    }

    private String createQueryParam(final Map.Entry<String, String> queryParam) {
        return queryParam.getKey() + "=" + queryParam.getValue();
    }

    private String getServicePath() {
        return restClient.getRestClientMetadata().getUrl();
    }

}
