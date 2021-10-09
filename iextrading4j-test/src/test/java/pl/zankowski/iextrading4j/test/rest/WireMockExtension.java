package pl.zankowski.iextrading4j.test.rest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

class WireMockExtension extends WireMockServer implements BeforeEachCallback, AfterEachCallback {

    public WireMockExtension(final int port) {
        super(port);
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        this.start();
        WireMock.configureFor("localhost", port());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        this.stop();
        this.resetAll();
    }
}
