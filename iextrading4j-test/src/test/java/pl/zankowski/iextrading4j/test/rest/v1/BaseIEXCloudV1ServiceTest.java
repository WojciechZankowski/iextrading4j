package pl.zankowski.iextrading4j.test.rest.v1;

import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudToken;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.test.rest.WireMockExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;

public abstract class BaseIEXCloudV1ServiceTest {

    protected static final IEXCloudToken CLOUD_TOKEN = new IEXCloudTokenBuilder()
            .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
            .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
            .build();

    @RegisterExtension
    public WireMockExtension wireMockRule = new WireMockExtension(8089);

    protected IEXCloudClient cloudClient;

    @BeforeEach
    public void setUp() throws Exception {
        cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, CLOUD_TOKEN);
    }

    @AfterEach
    public void tearDown() {
        cloudClient = null;
    }

    protected String extendedPath(final String path) {
        return path(path, CLOUD_TOKEN.getPublishableToken(), "&");
    }

    protected String path(final String path) {
        return path(path, CLOUD_TOKEN.getPublishableToken(), "?");
    }

    protected String secretPath(final String path) {
        return path(path, CLOUD_TOKEN.getSecretToken(), "?");
    }

    private String path(final String path, final String token, final String join) {
        return path + join + "token=" + token;
    }

    protected StringValuePattern bodyContent(final String token, final String body) {
        return equalToJson(new StringBuilder()
                .append("{")
                .append(tokenParameter(token))
                .append(", ")
                .append(body)
                .append("}")
                .toString());
    }

    private String tokenParameter(final String token) {
        return new StringBuilder()
                .append("\"token\": \"")
                .append(token)
                .append("\"")
                .toString();
    }


}
