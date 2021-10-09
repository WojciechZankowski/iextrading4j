package pl.zankowski.iextrading4j.client.rest.request.filter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RequestFilterBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequestFilter() {
        final RequestFilter requestFilter = new RequestFilterBuilder()
                .withColumn("first")
                .withColumn("second")
                .build();

        assertThat(requestFilter.getColumnList()).isEqualTo("first,second");
    }

}
