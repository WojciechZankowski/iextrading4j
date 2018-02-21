package pl.zankowski.iextrading4j.api.refdata;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class DailyList implements Serializable {

    private final String recordId;
    private final LocalDateTime dailyListTimestamp;

    public DailyList(final String recordId, final LocalDateTime dailyListTimestamp) {
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
