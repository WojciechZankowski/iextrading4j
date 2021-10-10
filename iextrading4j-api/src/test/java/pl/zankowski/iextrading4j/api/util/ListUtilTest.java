package pl.zankowski.iextrading4j.api.util;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListUtilTest {

    @Test
    void shouldCreateEmptyListForNullInput() {
        final List<String> result = ListUtil.immutableList(null);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldCreateImmutableListFromList() {
        final List<String> mutableList = new ArrayList<>();

        final List<String> immutableList = ListUtil.immutableList(mutableList);

        assertThat(immutableList).isInstanceOf(ImmutableList.class);
    }

}
