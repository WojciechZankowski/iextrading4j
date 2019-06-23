package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.account.Metadata;
import pl.zankowski.iextrading4j.api.account.Usage;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.account.MetadataRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.account.PayAsYouGoRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.account.UsageRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.account.UsageType;

import java.util.List;
import java.util.Map;

/**
 * This endpoints somehow does not work with Sandbox
 */
public class AccountSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("pk_")
                    .withSecretToken("sk_")
                    .build());

    public static void main(String[] args) {
        final AccountSample accountSample = new AccountSample();

        accountSample.metadataRequestSample();
        accountSample.messageUsageRequestSample();
        accountSample.usageRequestSample();
        accountSample.payAsYouGoSample();
    }

    private void metadataRequestSample() {
        final Metadata metadata = cloudClient.executeRequest(new MetadataRequestBuilder()
                .build());
        System.out.println(metadata);
    }

    private void messageUsageRequestSample() {
        final List<Usage> usage = cloudClient.executeRequest(new UsageRequestBuilder()
                .withUsageType(UsageType.MESSAGES)
                .build());
        System.out.println(usage);
    }

    private void usageRequestSample() {
        final Map<String, List<Usage>> usage = cloudClient.executeRequest(new UsageRequestBuilder().build());
        System.out.println(usage);
    }

    private void payAsYouGoSample() {
        final String test = cloudClient.executeRequest(new PayAsYouGoRequestBuilder()
                .withDisallowed()
                .build());
        System.out.println(test);
    }

}
