package pl.zankowski.iextrading4j.client.rest.manager;

import pl.zankowski.iextrading4j.api.exception.IEXTradingException;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class RestManager {

    private static final int SUCCESS = 200;
    private static final int WRITE_SUCCESS = 201;

    private final RestClient restClient;

    public RestManager(final RestClient restClient) {
        this.restClient = restClient;
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

            if (!isSuccessful(response)) {
                final String errorMessage = response.readEntity(String.class);
                throw new IEXTradingException(errorMessage, response.getStatus());
            }

            return new RestResponseBuilder<R>()
                    .withMessage(response.getStatusInfo().getReasonPhrase())
                    .withResponse(response.readEntity(restRequest.getResponseType()))
                    .build();
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    private boolean isSuccessful(final Response response) {
        return response.getStatus() == SUCCESS || response.getStatus() == WRITE_SUCCESS;
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
