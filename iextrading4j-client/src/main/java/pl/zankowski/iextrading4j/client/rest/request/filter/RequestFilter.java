package pl.zankowski.iextrading4j.client.rest.request.filter;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class RequestFilter {

    private final String columnList;

    public RequestFilter(final String columnList) {
        this.columnList = columnList;
    }

    public String getColumnList() {
        return columnList;
    }

    public static RequestFilterBuilder builder() {
        return new RequestFilterBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestFilter that = (RequestFilter) o;
        return Objects.equal(columnList, that.columnList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(columnList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("columnList", columnList)
                .toString();
    }
}
