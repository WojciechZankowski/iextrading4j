package pl.zankowski.iextrading4j.client.rest.request.filter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestFilterBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequestFilter() {
        final RequestFilter requestFilter = new RequestFilterBuilder()
                .withColumn("first")
                .withColumn("second")
                .build();

        assertThat(requestFilter.getColumnList()).isEqualTo("first,second");
    }

}
