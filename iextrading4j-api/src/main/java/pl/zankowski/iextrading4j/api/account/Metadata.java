package pl.zankowski.iextrading4j.api.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"payAsYouGoEnabled", "effectiveDate", "endDateEffective", "subscriptionTermType",
        "tierName", "messageLimit", "messagesUsed", "circuitBreaker"})
public class Metadata implements Serializable {

    private static final long serialVersionUID = -7626003595227020176L;

    private final Boolean payAsYouGoEnabled;
    private final Long effectiveDate;
    private final Long endDateEffective;
    private final String subscriptionTermType;
    private final String tierName;
    private final Long messageLimit;
    private final Long messagesUsed;
    private final Long circuitBreaker;

    @JsonCreator
    public Metadata(
            @JsonProperty("payAsYouGoEnabled") final Boolean payAsYouGoEnabled,
            @JsonProperty("effectiveDate") final Long effectiveDate,
            @JsonProperty("endDateEffective") final Long endDateEffective,
            @JsonProperty("subscriptionTermType") final String subscriptionTermType,
            @JsonProperty("tierName") final String tierName,
            @JsonProperty("messageLimit") final Long messageLimit,
            @JsonProperty("messagesUsed") final Long messagesUsed,
            @JsonProperty("circuitBreaker") final Long circuitBreaker) {
        this.payAsYouGoEnabled = payAsYouGoEnabled;
        this.effectiveDate = effectiveDate;
        this.endDateEffective = endDateEffective;
        this.subscriptionTermType = subscriptionTermType;
        this.tierName = tierName;
        this.messageLimit = messageLimit;
        this.messagesUsed = messagesUsed;
        this.circuitBreaker = circuitBreaker;
    }

    public Boolean getPayAsYouGoEnabled() {
        return payAsYouGoEnabled;
    }

    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public Long getEndDateEffective() {
        return endDateEffective;
    }

    public String getSubscriptionTermType() {
        return subscriptionTermType;
    }

    public String getTierName() {
        return tierName;
    }

    public Long getMessageLimit() {
        return messageLimit;
    }

    public Long getMessagesUsed() {
        return messagesUsed;
    }

    public Long getCircuitBreaker() {
        return circuitBreaker;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Metadata metadata = (Metadata) o;
        return Objects.equal(payAsYouGoEnabled, metadata.payAsYouGoEnabled) &&
                Objects.equal(effectiveDate, metadata.effectiveDate) &&
                Objects.equal(endDateEffective, metadata.endDateEffective) &&
                Objects.equal(subscriptionTermType, metadata.subscriptionTermType) &&
                Objects.equal(tierName, metadata.tierName) &&
                Objects.equal(messageLimit, metadata.messageLimit) &&
                Objects.equal(messagesUsed, metadata.messagesUsed) &&
                Objects.equal(circuitBreaker, metadata.circuitBreaker);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(payAsYouGoEnabled, effectiveDate, endDateEffective,
                subscriptionTermType, tierName, messageLimit, messagesUsed, circuitBreaker);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("payAsYouGoEnabled", payAsYouGoEnabled)
                .add("effectiveDate", effectiveDate)
                .add("endDateEffective", endDateEffective)
                .add("subscriptionTermType", subscriptionTermType)
                .add("tierName", tierName)
                .add("messageLimit", messageLimit)
                .add("messagesUsed", messagesUsed)
                .add("circuitBreaker", circuitBreaker)
                .toString();
    }

}
