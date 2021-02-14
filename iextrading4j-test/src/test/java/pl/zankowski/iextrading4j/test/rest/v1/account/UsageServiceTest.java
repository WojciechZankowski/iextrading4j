package pl.zankowski.iextrading4j.test.rest.v1.account;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.account.Usage;
import pl.zankowski.iextrading4j.client.rest.request.account.UsageRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.account.UsageType;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class UsageServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void usageServiceTest() {
        stubFor(get(urlEqualTo(secretPath("/account/usage")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/account/UsageResponse.json")));

        final Map<String, List<Usage>> result = cloudClient.executeRequest(new UsageRequestBuilder()
                .build());

        assertThat(result).hasSize(2);

        final List<Usage> rules = result.get(UsageType.RULES.getType());
        assertThat(rules).isEmpty();

        final List<Usage> messages = result.get(UsageType.MESSAGES.getType());
        assertThat(messages).hasSize(1);

        final Usage usage = messages.get(0);
        assertThat(usage.getMonthlyUsage()).isEqualTo(510327L);
        assertThat(usage.getMonthlyPayAsYouGo()).isEqualTo(57264350L);
        assertThat(usage.getDailyUsage()).containsExactly(entry("20190501", 1905341L));
        assertThat(usage.getTokenUsage()).containsExactly(entry("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2", 57358195L));
        assertThat(usage.getKeyUsage()).containsExactly(entry("UPCOMING_IPOS", 673738L), entry("PREVIOUS", 17815L));
    }

    @Test
    public void messageUsageServiceTest() {
        stubFor(get(urlEqualTo(secretPath("/account/usage/messages")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/account/MessageUsageResponse.json")));

        final List<Usage> result = cloudClient.executeRequest(new UsageRequestBuilder()
                .withUsageType(UsageType.MESSAGES)
                .build());

        assertThat(result).hasSize(1);

        final Usage usage = result.get(0);
        assertThat(usage.getMonthlyUsage()).isEqualTo(510327L);
        assertThat(usage.getMonthlyPayAsYouGo()).isEqualTo(57264350L);
        assertThat(usage.getDailyUsage()).containsExactly(entry("20190501", 1905341L));
        assertThat(usage.getTokenUsage()).containsExactly(entry("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2", 57358195L));
        assertThat(usage.getKeyUsage()).containsExactly(entry("UPCOMING_IPOS", 673738L), entry("PREVIOUS", 17815L));
    }

}
