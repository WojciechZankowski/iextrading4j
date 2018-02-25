package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType;

import static pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType.NOT_AVAILABLE;
import static pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType.NOT_QUALIFIED;
import static pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType.NO_AFFIRMATION;
import static pl.zankowski.iextrading4j.api.refdata.QualifiedDividendType.QUALIFIED;

class QualifiedDividendTypeDeserializer extends AbstractEnumDeserializer<QualifiedDividendType> {

    static final BiMap<String, QualifiedDividendType> QUALIFIED_DIVIDEND_TYPE_MAPPER = ImmutableBiMap.<String, QualifiedDividendType>builder()
            .put("Y", QUALIFIED)
            .put("N", NOT_QUALIFIED)
            .put("U", NO_AFFIRMATION)
            .put("", NOT_AVAILABLE)
            .build();

    QualifiedDividendTypeDeserializer() {
        super(QUALIFIED_DIVIDEND_TYPE_MAPPER, QualifiedDividendType.UNKNOWN);
    }

}
