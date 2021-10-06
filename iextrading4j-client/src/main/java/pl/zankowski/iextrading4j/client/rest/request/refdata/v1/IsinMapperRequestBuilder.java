package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import pl.zankowski.iextrading4j.api.refdata.v1.SymbolMapping;
import pl.zankowski.iextrading4j.client.rest.manager.PostEntity;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class IsinMapperRequestBuilder extends AbstractRequestFilterBuilder<List<List<SymbolMapping>>, IsinMapperRequestBuilder>
        implements IEXCloudV1RestRequest<List<List<SymbolMapping>>> {

    private final List<String> isinList = Lists.newArrayList();

    public IsinMapperRequestBuilder addIsin(final String isin) {
        isinList.add(isin);
        return this;
    }

    @Override
    public RestRequest<List<List<SymbolMapping>>> build() {
        return RestRequestBuilder.<List<List<SymbolMapping>>>builder()
                .withPath("/ref-data/isin").post()
                .withRequest(new IsinPostEntity(isinList))
                .withResponse(new GenericType<List<List<SymbolMapping>>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }

    static class IsinPostEntity extends PostEntity {

        private static final long serialVersionUID = -3553375472577931811L;

        private final List<String> isin;

        public IsinPostEntity(final List<String> isin) {
            this.isin = immutableList(isin);
        }

        public List<String> getIsin() {
            return isin;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            if (!super.equals(o)) {
                return false;
            }
            final IsinPostEntity that = (IsinPostEntity) o;
            return Objects.equal(isin, that.isin);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), isin);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("isin", isin)
                    .toString();
        }

    }

}
