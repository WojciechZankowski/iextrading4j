package pl.zankowski.iextrading4j.api.util;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetUtilTest {

    @Test
    void shouldCreateEmptySetForNullInput() {
        final Set<String> result = SetUtil.immutableSet(null);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldCreateImmutableSetFromSet() {
        final Set<String> mutableSet = new HashSet<>();

        final Set<String> immutableSet = SetUtil.immutableSet(mutableSet);

        assertThat(immutableSet).isInstanceOf(ImmutableSet.class);
    }

}
