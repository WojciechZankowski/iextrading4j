package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.options.Option;
import pl.zankowski.iextrading4j.client.rest.request.options.OptionSide;
import pl.zankowski.iextrading4j.client.rest.request.options.OptionsRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionsAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    public void optionsTest() {
        final List<String> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void optionsWithExpirationDateTest() {
        final List<Option> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .withExpirationDate("201906")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void optionsWithExpirationDateAndSideTest() {
        final List<Option> result = cloudClient.executeRequest(new OptionsRequestBuilder()
                .withSymbol("AAPL")
                .withExpirationDate("201906")
                .withSide(OptionSide.CALL)
                .build());
        assertThat(result).isNotNull();
    }

}
