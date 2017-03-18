package pl.zankowski.iextrading4j.client.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wojciech Zankowski
 */
public class LocalDateObjectMapperContextResolverTest {

    @Test
    public void objectMapperShouldBeNotNull() {
        LocalDateObjectMapperContextResolver localDateObjectMapperContextResolver = new LocalDateObjectMapperContextResolver();
        ObjectMapper objectMapper = localDateObjectMapperContextResolver.getContext(String.class);

        assertThat(objectMapper).isNotNull();
    }

}
