package pl.zankowski.iextrading4j.client.rest.request.corporate;

import pl.zankowski.iextrading4j.api.corporate.AdvancedSplits;
import pl.zankowski.iextrading4j.client.rest.request.datapoint.AbstractStockTimeSeriesRequestBuilder;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class AdvancedSplitsRequestBuilder extends AbstractStockTimeSeriesRequestBuilder<List<AdvancedSplits>,
        AdvancedSplitsRequestBuilder> {

    public AdvancedSplitsRequestBuilder() {
        super("advanced_splits", new GenericType<List<AdvancedSplits>>() {
        });
    }
}
