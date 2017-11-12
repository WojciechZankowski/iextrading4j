package pl.zankowski.iextrading4j.api.util;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapUtilTest {

    @Test
    public void shouldCreateEmptyMapForNullInput() {
        final Map<String, String> result = MapUtil.immutableMap(null);

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldCreateImmutableMapFromMap() {
        final Map<String, String> mutableMap = new HashMap<>();

        final Map<String, String> immutableMap = MapUtil.immutableMap(mutableMap);

        assertThat(immutableMap).isInstanceOf(ImmutableMap.class);
    }

}
