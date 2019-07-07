package pl.zankowski.iextrading4j.client.rest.request.system;

import pl.zankowski.iextrading4j.api.system.SystemStatus;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

public class SystemStatusRequestBuilder implements IEXCloudV1RestRequest<SystemStatus> {

    @Override
    public RestRequest<SystemStatus> build() {
        return RestRequestBuilder.<SystemStatus>builder()
                .withPath("/status").get()
                .withResponse(SystemStatus.class)
                .build();
    }

}
