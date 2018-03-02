package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicChartTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final ChartRange chartRange = fixture.create(ChartRange.class);
        final List<Chart> chartList = Lists.newArrayList(fixture.collections().createCollection(Chart.class));

        final DynamicChart dynamicChart = new DynamicChart(chartRange, chartList);

        assertThat(dynamicChart.getRange()).isEqualTo(chartRange);
        assertThat(dynamicChart.getData()).isEqualTo(chartList);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(DynamicChart.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(DynamicChart.class))
                .verify();
    }

}
