package pl.zankowski.iextrading4j.api.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Metadata implements Serializable {

    private static final long serialVersionUID = -7626003595227020176L;

    private final Boolean payAsYouGoEnabled;
    private final Long effectiveDate;
    private final Long endDateEffective;
    private final String subscriptionTermType;
    private final String tierName;
    private final Long messageLimit;
    private final Long creditLimit;
    private final Long messagesUsed;
    private final Long creditsUsed;
    private final Long circuitBreaker;

    @JsonCreator
    public Metadata(
            @JsonProperty("payAsYouGoEnabled") final Boolean payAsYouGoEnabled,
            @JsonProperty("effectiveDate") final Long effectiveDate,
            @JsonProperty("endDateEffective") final Long endDateEffective,
            @JsonProperty("subscriptionTermType") final String subscriptionTermType,
            @JsonProperty("tierName") final String tierName,
            @JsonProperty("messageLimit") final Long messageLimit,
            @JsonProperty("creditLimit") final Long creditLimit,
            @JsonProperty("messagesUsed") final Long messagesUsed,
            @JsonProperty("creditsUsed") final Long creditsUsed,
            @JsonProperty("circuitBreaker") final Long circuitBreaker) {
        this.payAsYouGoEnabled = payAsYouGoEnabled;
        this.effectiveDate = effectiveDate;
        this.endDateEffective = endDateEffective;
        this.subscriptionTermType = subscriptionTermType;
        this.tierName = tierName;
        this.messageLimit = messageLimit;
        this.creditLimit = creditLimit;
        this.messagesUsed = messagesUsed;
        this.creditsUsed = creditsUsed;
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

    public Long getCreditLimit() {
        return creditLimit;
    }

    public Long getMessagesUsed() {
        return messagesUsed;
    }

    public Long getCreditsUsed() {
        return creditsUsed;
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
        return Objects.equals(payAsYouGoEnabled, metadata.payAsYouGoEnabled) &&
                Objects.equals(effectiveDate, metadata.effectiveDate) &&
                Objects.equals(endDateEffective, metadata.endDateEffective) &&
                Objects.equals(subscriptionTermType, metadata.subscriptionTermType) &&
                Objects.equals(tierName, metadata.tierName) &&
                Objects.equals(messageLimit, metadata.messageLimit) &&
                Objects.equals(creditLimit, metadata.creditLimit) &&
                Objects.equals(messagesUsed, metadata.messagesUsed) &&
                Objects.equals(creditsUsed, metadata.creditsUsed) &&
                Objects.equals(circuitBreaker, metadata.circuitBreaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payAsYouGoEnabled, effectiveDate, endDateEffective, subscriptionTermType, tierName,
                messageLimit, creditLimit, messagesUsed, creditsUsed, circuitBreaker);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Metadata.class.getSimpleName() + "[", "]")
                .add("payAsYouGoEnabled=" + payAsYouGoEnabled)
                .add("effectiveDate=" + effectiveDate)
                .add("endDateEffective=" + endDateEffective)
                .add("subscriptionTermType='" + subscriptionTermType + "'")
                .add("tierName='" + tierName + "'")
                .add("messageLimit=" + messageLimit)
                .add("creditLimit=" + creditLimit)
                .add("messagesUsed=" + messagesUsed)
                .add("creditsUsed=" + creditsUsed)
                .add("circuitBreaker=" + circuitBreaker)
                .toString();
    }
}
