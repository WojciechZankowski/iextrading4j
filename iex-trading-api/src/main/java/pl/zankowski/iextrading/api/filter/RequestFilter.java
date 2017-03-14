package pl.zankowski.iextrading.api.filter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Wojciech Zankowski
 */
public class RequestFilter {

	public static final String FILTER_DELIMITER = ",";
	public static final String FILTER_QUERY_NAME = "filter";

	private final String columnList;

	public RequestFilter(String columnList) {
		this.columnList = columnList;
	}

	public String getColumnList() {
		return columnList;
	}

	public static RequestFilter.Builder builder() {
		return new RequestFilter.Builder();
	}

	public static class Builder {

		private final Set<String> columns = new HashSet<>();

		public Builder with(String column) {
			this.columns.add(column);
			return this;
		}

		public RequestFilter build() {
			return new RequestFilter(columns.stream().collect(Collectors.joining(FILTER_DELIMITER)));
		}

	}

}
