package pl.zankowski.iextrading4j.client.rest.request.refdata;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractDailyListRequestBuilderTest {

    @Test
    void shouldReturnSample() {
        final IEXCorporateActionsRequestBuilder requestBuilder = new IEXCorporateActionsRequestBuilder().withSample();

        final String period = requestBuilder.getPeriod();

        assertThat(period).isEqualTo("sample");
    }

    @Test
    void shouldReturnEmptyString() {
        final IEXCorporateActionsRequestBuilder requestBuilder = new IEXCorporateActionsRequestBuilder();

        final String period = requestBuilder.getPeriod();

        assertThat(period).isEmpty();
    }

    @Test
    void shouldReturnFormattedDate() {
        final IEXCorporateActionsRequestBuilder requestBuilder = new IEXCorporateActionsRequestBuilder()
                .withDate(LocalDate.of(2017, 7, 7));

        final String period = requestBuilder.getPeriod();

        assertThat(period).isEqualTo("20170707");
    }

}
