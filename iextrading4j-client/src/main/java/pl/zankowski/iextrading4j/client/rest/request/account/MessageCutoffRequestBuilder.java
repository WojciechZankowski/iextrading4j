package pl.zankowski.iextrading4j.client.rest.request.account;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.client.rest.manager.PostEntity;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;

public class MessageCutoffRequestBuilder extends AbstractRequestFilterBuilder<String, MessageCutoffRequestBuilder>
        implements IEXCloudV1RestRequest<String> {

    private Long totalMessages;

    public MessageCutoffRequestBuilder withTotalMessages(final Long totalMessages) {
        this.totalMessages = totalMessages;
        return this;
    }

    @Override
    public RestRequest<String> build() {
        return RestRequestBuilder.<String>builder()
                .withPath("/account/circuitbreaker").post()
                .withRequest(new MessageCutoffPostEntity(totalMessages))
                .withResponse(new GenericType<String>() {
                })
                .withSecretToken()
                .addQueryParam(getFilterParams())
                .build();
    }

    static class MessageCutoffPostEntity extends PostEntity {

        private static final long serialVersionUID = -1499748924717100344L;

        private final Long totalMessages;

        public MessageCutoffPostEntity(final Long totalMessages) {
            this.totalMessages = totalMessages;
        }

        public Long getTotalMessages() {
            return totalMessages;
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
            final MessageCutoffPostEntity that = (MessageCutoffPostEntity) o;
            return Objects.equal(totalMessages, that.totalMessages);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), totalMessages);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("totalMessages", totalMessages)
                    .toString();
        }
    }

}
