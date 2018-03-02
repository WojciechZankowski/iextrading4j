package pl.zankowski.iextrading4j.api.stocks;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChartRangeTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        final String code = "12m";

        ChartRange.getValueFromCode(code);
    }


    @Test
    public void shouldCreateEnumFromCode() {
        final String code = "6m";

        final ChartRange chartRange = ChartRange.getValueFromCode(code);

        assertThat(chartRange).isEqualTo(ChartRange.SIX_MONTHS);
    }

}
