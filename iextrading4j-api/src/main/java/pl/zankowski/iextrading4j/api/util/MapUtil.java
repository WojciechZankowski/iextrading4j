package pl.zankowski.iextrading4j.api.util;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MapUtil {

    private MapUtil() {
    }

    public static <K, V> Map<K, V> immutableMap(final Map<K, V> map) {
        return map == null
                ? ImmutableMap.of()
                : ImmutableMap.copyOf(map);
    }

}
