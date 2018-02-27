package pl.zankowski.iextrading4j.api.util;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO Extend it to real implementation, extract to library
 */
public class ToStringVerifier {

    private final Object object;

    private ToStringVerifier(final Object object) {
        this.object = object;
    }

    public static ToStringVerifier forObject(final Object object) {
        return new ToStringVerifier(object);
    }

    public void verify() {
        assertThat(object.toString()).isNotEmpty();
    }

}
