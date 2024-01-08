package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.SymbolMapping;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IsinMapperRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final String isin = "DST232312312";

        final RestRequest<List<List<SymbolMapping>>> request = new IsinMapperRequestBuilder()
                .addIsin(isin)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.POST);
        assertThat(request.getPath()).isEqualTo("/ref-data/isin");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<List<SymbolMapping>>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();

        final List<String> isins = ((IsinMapperRequestBuilder.IsinPostEntity) request.getRequestEntity()).getIsin();
        assertThat(isins).containsExactly(isin);
    }

}
