package pl.zankowski.iextrading4j.api.filter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class RequestFilterTest {

    @Test
    public void shouldReturnTheSameObjectAsProvidedInConstructor() {
        final String columnList = "marketPrice;symbol";
        RequestFilter requestFilter = new RequestFilter(columnList);

        assertThat(requestFilter.getColumnList()).isEqualTo(columnList);
    }

    @Test
    public void shouldReturnEmptyColumnList() {
        RequestFilter requestFilter = RequestFilter.builder().build();

        assertThat(requestFilter.getColumnList()).isEmpty();
    }

    @Test
    public void shouldReturnSingleColumnInColumnList() {
        final String column = "marketPrice";
        RequestFilter requestFilter = RequestFilter.builder().with(column).build();

        assertThat(requestFilter.getColumnList()).isEqualTo(column);
    }

    @Test
    public void shouldReturnMultipleColumnsInColumnList() {
        final String marketPriceColumn = "marketPrice";
        final String symbolColumn = "symbol";
        RequestFilter requestFilter = RequestFilter.builder()
                .with(marketPriceColumn)
                .with(symbolColumn)
                .build();

        String[] elements = requestFilter.getColumnList().split(RequestFilter.FILTER_DELIMITER);
        assertThat(elements).hasSize(2);
        assertThat(elements).contains(marketPriceColumn);
        assertThat(elements).contains(symbolColumn);
    }

}
