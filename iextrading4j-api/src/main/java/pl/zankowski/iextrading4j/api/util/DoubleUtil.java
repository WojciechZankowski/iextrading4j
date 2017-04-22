package pl.zankowski.iextrading4j.api.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * @author Wojciech Zankowski
 */
public class DoubleUtil {

    private DoubleUtil() {}

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

    static {
        DECIMAL_FORMAT.setMaximumFractionDigits(340);
    }

    public static String printDouble(double value) {
        return DECIMAL_FORMAT.format(value);
    }

}
