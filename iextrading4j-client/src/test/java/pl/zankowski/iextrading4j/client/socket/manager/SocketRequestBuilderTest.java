package pl.zankowski.iextrading4j.client.socket.manager;

import com.flextrade.jfixture.JFixture;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SocketRequestBuilderTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void shouldSuccessfullyCreateSocketRequest() {
        final String path = fixture.create(String.class);

        final SocketRequest<String> request = SocketRequestBuilder.<String>builder()
                .withPath(path)
                .withResponse(String.class)
                .build();

        assertThat(request.getParams()).isEmpty();
        assertThat(request.getPath()).isEqualTo(path);
    }

}
