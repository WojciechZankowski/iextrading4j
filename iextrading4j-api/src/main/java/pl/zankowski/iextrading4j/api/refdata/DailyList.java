package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonPropertyOrder({"RecordId", "DailyListTimestamp"})
public abstract class DailyList implements Serializable {

    private final String recordId;
    private final LocalDateTime dailyListTimestamp;

    @JsonCreator
    public DailyList(
            @JsonProperty("RecordID") final String recordId,
            @JsonProperty("DailyListTimestamp") final LocalDateTime dailyListTimestamp) {
        this.recordId = recordId;
        this.dailyListTimestamp = dailyListTimestamp;
    }

    public String getRecordId() {
        return recordId;
    }

    public LocalDateTime getDailyListTimestamp() {
        return dailyListTimestamp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DailyList dailyList = (DailyList) o;
        return Objects.equals(recordId, dailyList.recordId) &&
                Objects.equals(dailyListTimestamp, dailyList.dailyListTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, dailyListTimestamp);
    }

}
