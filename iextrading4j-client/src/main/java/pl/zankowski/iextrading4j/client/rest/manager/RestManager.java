package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.api.exception.IEXTradingException;
import pl.zankowski.iextrading4j.client.IEXCloudToken;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import static java.util.stream.Collectors.joining;

public class RestManager {

    private static final String TOKEN_QUERY_PARAM = "token";
    private static final int SUCCESS = 200;
    private static final int WRITE_SUCCESS = 201;

    private final RestClient restClient;

    public RestManager(final RestClient restClient) {
        this.restClient = restClient;
    }

    public <R> RestResponse<R> executeRequest(final RestRequest<R> restRequest) {
        final String url = createURL(restRequest, restClient.getRestClientMetadata().getToken(),
                restClient.getRestClientMetadata().getUrl());

        final Invocation.Builder invocationBuilder = restClient.getClient().target(url)
                .register(JacksonJsonProvider.class)
                .request(MediaType.APPLICATION_JSON);

        Response response = null;

        try {

            switch (restRequest.getMethodType()) {
                case GET:
                    response = invocationBuilder.get();
                    break;
                case POST:
                    final PostEntity requestEntity = restRequest.getRequestEntity();
                    requestEntity.setToken(resolveToken(restRequest,
                            restClient.getRestClientMetadata().getToken()));
                    response = invocationBuilder.post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
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

    private <R> String createURL(final RestRequest<R> restRequest, final IEXCloudToken token, final String url) {
        return new StringBuilder()
                .append(url)
                .append(createPath(restRequest.getPath(), restRequest.getPathParams()))
                .append(createQueryParameters(restRequest.getQueryParams(), resolveUrlToken(restRequest, token)))
                .toString();
    }

    private <R> String resolveUrlToken(final RestRequest<R> restRequest, final IEXCloudToken token) {
        return restRequest.getMethodType() != MethodType.GET ? null : resolveToken(restRequest, token);
    }

    private <R> String resolveToken(final RestRequest<R> restRequest, final IEXCloudToken token) {
        return token == null
                ? null
                : restRequest.getUseSecretToken()
                ? token.getSecretToken()
                : token.getPublishableToken();
    }


    private String createPath(final String originalPath, final Map<String, String> pathParams) {
        String path = originalPath;
        for (final Map.Entry<String, String> entry : pathParams.entrySet()) {
            path = path.replaceFirst("\\{" + entry.getKey() + "\\}", entry.getValue());
        }

        return path;
    }

    private String createQueryParameters(final Map<String, String> queryParams, final String publishableToken) {
        if (queryParams.isEmpty() && publishableToken == null) {
            return "";
        }

        final Map<String, String> paramsCopy = Maps.newHashMap(queryParams);
        if (publishableToken != null) {
            paramsCopy.put(TOKEN_QUERY_PARAM, publishableToken);
        }

        return paramsCopy.entrySet().stream()
                .map(this::createQueryParam)
                .collect(joining("&", "?", ""));
    }

    private String createQueryParam(final Map.Entry<String, String> queryParam) {
        return queryParam.getKey() + "=" + queryParam.getValue();
    }

}
