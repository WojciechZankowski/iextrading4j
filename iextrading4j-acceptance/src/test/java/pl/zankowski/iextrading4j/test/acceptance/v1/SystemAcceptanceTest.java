package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.system.SystemStatus;
import pl.zankowski.iextrading4j.client.rest.request.system.SystemStatusRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    public void systemStatusTest() {
        final SystemStatus systemStatus = cloudClient.executeRequest(new SystemStatusRequestBuilder()
                .build());
        System.out.println(systemStatus);
        assertThat(systemStatus).isNotNull();
    }

}
