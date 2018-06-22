package pl.zankowski.iextrading4j.api.util;

import com.google.common.collect.ImmutableSet;

import java.util.Collection;
import java.util.Set;

public class SetUtil {

    private SetUtil() {}

    public static <T> Set<T> immutableSet(final Collection<? extends T> elements) {
        return elements == null
                ? ImmutableSet.of()
                : ImmutableSet.copyOf(elements);
    }

}
