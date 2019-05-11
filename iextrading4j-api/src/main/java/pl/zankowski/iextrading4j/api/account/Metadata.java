package pl.zankowski.iextrading4j.api.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"overagesEnabled", "effectiveDate", "endDateEffective", "subscriptionTermType",
        "tierName", "messageLimit", "messagesUsed"})
public class Metadata implements Serializable {

    private final Boolean overagesEnabled;
    private final Long effectiveDate;
    private final Long endDateEffective;
    private final String subscriptionTermType;
    private final String tierName;
    private final Long messageLimit;
    private final Long messagesUsed;

    @JsonCreator
    public Metadata(
            @JsonProperty("overagesEnabled") final Boolean overagesEnabled,
            @JsonProperty("effectiveDate") final Long effectiveDate,
            @JsonProperty("endDateEffective") final Long endDateEffective,
            @JsonProperty("subscriptionTermType") final String subscriptionTermType,
            @JsonProperty("tierName") final String tierName,
            @JsonProperty("messageLimit") final Long messageLimit,
            @JsonProperty("messagesUsed") final Long messagesUsed) {
        this.overagesEnabled = overagesEnabled;
        this.effectiveDate = effectiveDate;
        this.endDateEffective = endDateEffective;
        this.subscriptionTermType = subscriptionTermType;
        this.tierName = tierName;
        this.messageLimit = messageLimit;
        this.messagesUsed = messagesUsed;
    }

    public Boolean getOveragesEnabled() {
        return overagesEnabled;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Metadata metadata = (Metadata) o;
        return Objects.equal(overagesEnabled, metadata.overagesEnabled) &&
                Objects.equal(effectiveDate, metadata.effectiveDate) &&
                Objects.equal(endDateEffective, metadata.endDateEffective) &&
                Objects.equal(subscriptionTermType, metadata.subscriptionTermType) &&
                Objects.equal(tierName, metadata.tierName) &&
                Objects.equal(messageLimit, metadata.messageLimit) &&
                Objects.equal(messagesUsed, metadata.messagesUsed);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(overagesEnabled, effectiveDate, endDateEffective,
                subscriptionTermType, tierName, messageLimit, messagesUsed);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overagesEnabled", overagesEnabled)
                .add("effectiveDate", effectiveDate)
                .add("endDateEffective", endDateEffective)
                .add("subscriptionTermType", subscriptionTermType)
                .add("tierName", tierName)
                .add("messageLimit", messageLimit)
                .add("messagesUsed", messagesUsed)
                .toString();
    }

}
