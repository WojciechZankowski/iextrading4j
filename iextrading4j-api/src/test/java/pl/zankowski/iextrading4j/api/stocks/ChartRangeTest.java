package pl.zankowski.iextrading4j.api.stocks;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChartRangeTest {

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        final String code = "12m";

        assertThrows(IllegalArgumentException.class, () -> ChartRange.getValueFromCode(code));
    }


    @Test
    void shouldCreateEnumFromCode() {
        final String code = "6m";

        final ChartRange chartRange = ChartRange.getValueFromCode(code);

        assertThat(chartRange).isEqualTo(ChartRange.SIX_MONTHS);
    }

}
