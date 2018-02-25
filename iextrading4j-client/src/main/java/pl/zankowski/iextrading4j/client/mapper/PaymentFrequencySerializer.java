package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.PaymentFrequency;

import static pl.zankowski.iextrading4j.client.mapper.PaymentFrequencyDeserializer.PAYMENT_FREQUENCY_MAPPER;

class PaymentFrequencySerializer extends AbstractEnumSerializer<PaymentFrequency> {

    PaymentFrequencySerializer() {
        super(PAYMENT_FREQUENCY_MAPPER.inverse(), PaymentFrequency.UNKNOWN);
    }

}
