package pl.zankowski.iextrading4j.api.util;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetUtilTest {

    @Test
    public void shouldCreateEmptySetForNullInput() {
        final Set<String> result = SetUtil.immutableSet(null);

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldCreateImmutableSetFromSet() {
        final Set<String> mutableSet = new HashSet<>();

        final Set<String> immutableSet = SetUtil.immutableSet(mutableSet);

        assertThat(immutableSet).isInstanceOf(ImmutableSet.class);
    }

}
