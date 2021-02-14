package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.HolidayAndTradingDate;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.DateDirection;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.DateType;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.UsHolidayAndTradingDateRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class UsHolidayAndTradingDateServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void usHolidayAndTradingDateServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/us/dates/trade/next/2/20190530")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/UsHolidayAndTradingDateResponse.json")));

        final List<HolidayAndTradingDate> result = cloudClient.executeRequest(new UsHolidayAndTradingDateRequestBuilder()
                .withType(DateType.TRADE)
                .withDirection(DateDirection.NEXT)
                .withLast(2)
                .withStartDate(LocalDate.of(2019, 5, 30))
                .build());

        assertThat(result).hasSize(2);

        final HolidayAndTradingDate firstDate = result.get(0);
        assertThat(firstDate.getDate()).isEqualTo(LocalDate.of(2018, 5, 11));
        assertThat(firstDate.getSettlementDate()).isEqualTo(LocalDate.of(2018, 5, 15));

        final HolidayAndTradingDate secondDate = result.get(1);
        assertThat(secondDate.getDate()).isEqualTo(LocalDate.of(2018, 5, 14));
        assertThat(secondDate.getSettlementDate()).isEqualTo(LocalDate.of(2018, 5, 16));
    }

}
