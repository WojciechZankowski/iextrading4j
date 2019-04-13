package pl.zankowski.iextrading4j.sample.rest;

import pl.zankowski.iextrading4j.api.account.Metadata;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.account.MetadataRequestBuilder;

public class AccountSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1,
            "sk_f8368334f4214796aae2f66b7dbf92ed");

    public static void main(String[] args) {
        final AccountSample accountSample = new AccountSample();

        accountSample.metadataRequestSample();
    }

    private void metadataRequestSample() {
        final Metadata metadata = cloudClient.executeRequest(new MetadataRequestBuilder()
                .build());
        System.out.println(metadata);
    }

}
