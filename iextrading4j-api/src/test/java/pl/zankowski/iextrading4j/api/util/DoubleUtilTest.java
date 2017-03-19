package pl.zankowski.iextrading4j.api.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class DoubleUtilTest {

    @Test
    public void shouldPrint1234567() {
        double value = 1234567d;
        String printedValue = DoubleUtil.printDouble(value);

        assertThat(printedValue).isEqualTo("1234567");
    }

    @Test
    public void shouldPrint123_4567() {
        double value = 123.4567d;
        String printedValue = DoubleUtil.printDouble(value);

        assertThat(printedValue).isEqualTo("123.4567");
    }

    @Test
    public void shouldPrint0_123456789() {
        double value = 0.123456789d;
        String printedValue = DoubleUtil.printDouble(value);

        assertThat(printedValue).isEqualTo("0.123456789");
    }

    @Test
    public void shouldPrint123456789_987654321() {
        double value = 123456789.987654d;
        String printedValue = DoubleUtil.printDouble(value);

        assertThat(printedValue).isEqualTo("123456789.987654");
    }

}
