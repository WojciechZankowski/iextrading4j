package pl.zankowski.iextrading4j.client.rest.manager;

public class RestResponseBuilder<R> {

    private R response;
    private String message;

    public RestResponseBuilder<R> withResponse(R response) {
        this.response = response;
        return this;
    }

    public RestResponseBuilder<R> withMessage(String message) {
        this.message = message;
        return this;
    }

    public RestResponse<R> build() {
        return new RestResponse<>(response, message);
    }

}
