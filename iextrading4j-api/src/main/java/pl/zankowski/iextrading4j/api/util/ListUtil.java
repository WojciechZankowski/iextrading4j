package pl.zankowski.iextrading4j.api.util;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListUtil {

    public static <T> List<T> immutableList(final Collection<? extends T> elements) {
        return elements == null
                ? ImmutableList.of()
                : ImmutableList.copyOf(elements);
    }

}
