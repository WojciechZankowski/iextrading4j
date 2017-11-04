package pl.zankowski.iextrading4j.api.filter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RequestFilterBuilder {

    private static final String FILTER_DELIMITER = ",";

    private final Set<String> columns = new HashSet<>();

    public RequestFilterBuilder withColumn(String column) {
        this.columns.add(column);
        return this;
    }

    public RequestFilter build() {
        return new RequestFilter(columns.stream().collect(Collectors.joining(FILTER_DELIMITER)));
    }

}
