package pl.zankowski.iextrading4j.client.util;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Wojciech Zankowski
 */
public class PathUtilTest {

    private Client client;

    @Before
    public void setUp() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void shouldAddParamValueQueryToPath() {
        final String expectedURL = "http://localhost:8080/?param=value";
        WebTarget webTarget = client.target("http://localhost:8080");
        webTarget = PathUtil.appendQuery(webTarget, "param", "value");

        assertThat(webTarget.getUri().toString()).isEqualTo(expectedURL);
    }

    @Test
    public void shouldAddTwoParamValueQueriesToPath() {
        final String expectedURL = "http://localhost:8080/?param1=value1&param2=value2";
        WebTarget webTarget = client.target("http://localhost:8080");
        webTarget = PathUtil.appendQuery(webTarget, "param1", "value1");
        webTarget = PathUtil.appendQuery(webTarget, "param2", "value2");

        assertThat(webTarget.getUri().toString()).isEqualTo(expectedURL);
    }

    @Test
    public void shouldAppendNoPathsToURL() {
        final String expectedURL = "http://localhost:8080";
        WebTarget webTarget = client.target("http://localhost:8080");
        webTarget = PathUtil.appendPaths(webTarget);

        assertThat(webTarget.getUri().toString()).isEqualTo(expectedURL);
    }

    @Test
    public void shouldAppendOnePathToURL() {
        final String expectedURL = "http://localhost:8080/path";
        WebTarget webTarget = client.target("http://localhost:8080");
        webTarget = PathUtil.appendPaths(webTarget, "path");

        assertThat(webTarget.getUri().toString()).isEqualTo(expectedURL);
    }

    @Test
    public void shouldAppendMultiplePathsToURL() {
        final String expectedURL = "http://localhost:8080/path1/path2/path3";
        WebTarget webTarget = client.target("http://localhost:8080");
        webTarget = PathUtil.appendPaths(webTarget, "path1", "path2", "path3");

        assertThat(webTarget.getUri().toString()).isEqualTo(expectedURL);
    }

}
