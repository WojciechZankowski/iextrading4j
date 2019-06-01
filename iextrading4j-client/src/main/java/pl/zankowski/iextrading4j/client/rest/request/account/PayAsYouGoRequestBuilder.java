package pl.zankowski.iextrading4j.client.rest.request.account;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.client.rest.manager.PostEntity;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;

public class PayAsYouGoRequestBuilder extends AbstractRequestFilterBuilder<String, PayAsYouGoRequestBuilder>
        implements IEXCloudV1RestRequest<String> {

    private boolean allow = false;

    public PayAsYouGoRequestBuilder withDisallowed() {
        this.allow = false;
        return this;
    }

    public PayAsYouGoRequestBuilder withAllowed() {
        this.allow = true;
        return this;
    }

    @Override
    public RestRequest<String> build() {
        return RestRequestBuilder.<String>builder()
                .withPath("/account/payasyougo").post()
                .withRequest(new PayAsYouGoPostEntity(allow))
                .withResponse(new GenericType<String>() {
                })
                .withSecretToken()
                .addQueryParam(getFilterParams())
                .build();
    }

    static class PayAsYouGoPostEntity extends PostEntity {

        private static final long serialVersionUID = 8560191976863485871L;

        private boolean allow;

        public PayAsYouGoPostEntity(final boolean allow) {
            this.allow = allow;
        }

        public boolean isAllow() {
            return allow;
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
            final PayAsYouGoPostEntity that = (PayAsYouGoPostEntity) o;
            return allow == that.allow;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), allow);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("allow", allow)
                    .toString();
        }

    }


}
