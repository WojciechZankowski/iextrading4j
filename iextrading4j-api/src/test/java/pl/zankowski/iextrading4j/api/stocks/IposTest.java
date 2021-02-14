package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IposTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final List<Ipo> rawData = Lists.newArrayList(fixture.collections().createCollection(Ipo.class));
        final List<IpoSummary> viewData = Lists.newArrayList(fixture.collections().createCollection(IpoSummary.class));

        final Ipos ipos = new Ipos(rawData, viewData);

        assertThat(ipos.getRawData()).isEqualTo(rawData);
        assertThat(ipos.getViewData()).isEqualTo(viewData);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Ipos.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Ipos.class))
                .verify();
    }

}
