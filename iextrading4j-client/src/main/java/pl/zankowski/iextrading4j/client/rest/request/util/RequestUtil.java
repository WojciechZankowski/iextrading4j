package pl.zankowski.iextrading4j.client.rest.request.util;

import java.time.format.DateTimeFormatter;

public class RequestUtil {

    public static final DateTimeFormatter IEX_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter IEX_YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");

}
