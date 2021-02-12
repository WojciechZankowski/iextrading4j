package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.corporate.AdvancedBonus;
import pl.zankowski.iextrading4j.api.corporate.AdvancedDistribution;
import pl.zankowski.iextrading4j.client.rest.request.corporate.AdvancedBonusRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.corporate.AdvancedDistributionRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CorporateActionsAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    public void advancedBonusAcceptanceTest() {
        final List<AdvancedBonus> advancedBonus = cloudClient.executeRequest(
                new AdvancedBonusRequestBuilder()
                        .withSymbol("AAPL")
                        .build());
        assertThat(advancedBonus).isNotNull();
    }

    @Test
    public void advancedDistributionAcceptanceTest() {
        final List<AdvancedDistribution> advancedDistributions = cloudClient.executeRequest(
                new AdvancedDistributionRequestBuilder()
                        .withSymbol("KERRF")
                        .build());
        assertThat(advancedDistributions).isNotNull();
    }

}
