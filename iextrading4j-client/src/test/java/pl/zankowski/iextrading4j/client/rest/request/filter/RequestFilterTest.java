package pl.zankowski.iextrading4j.client.rest.request.filter;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestFilterTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String columnList = fixture.create(String.class);

        final RequestFilter requestFilter = new RequestFilter(columnList);

        assertThat(requestFilter.getColumnList()).isEqualTo(columnList);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(RequestFilter.class)
                .usingGetClass()
                .verify();
    }

}
