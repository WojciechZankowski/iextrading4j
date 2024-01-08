package pl.zankowski.iextrading4j.client.rest.request.corporate;

import pl.zankowski.iextrading4j.api.corporate.AdvancedBonus;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.AbstractStockTimeSeriesRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class AdvancedBonusRequestBuilder extends AbstractStockTimeSeriesRequestBuilder<List<AdvancedBonus>,
        AdvancedBonusRequestBuilder> {

    public AdvancedBonusRequestBuilder() {
        super("advanced_bonus", new GenericType<List<AdvancedBonus>>() {});
    }

}
