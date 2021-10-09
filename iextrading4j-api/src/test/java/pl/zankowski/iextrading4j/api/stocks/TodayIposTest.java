package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TodayIposTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final List<Ipo> rawData = Lists.newArrayList(fixture.collections().createCollection(Ipo.class));
        final List<IpoSummary> viewData = Lists.newArrayList(fixture.collections().createCollection(IpoSummary.class));
        final LocalDate lastUpdated = fixture.create(LocalDate.class);

        final TodayIpos todayIpos = new TodayIpos(rawData, viewData, lastUpdated);

        assertThat(todayIpos.getRawData()).isEqualTo(rawData);
        assertThat(todayIpos.getViewData()).isEqualTo(viewData);
        assertThat(todayIpos.getLastUpdate()).isEqualTo(lastUpdated);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(TodayIpos.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TodayIpos.class))
                .verify();
    }

}
