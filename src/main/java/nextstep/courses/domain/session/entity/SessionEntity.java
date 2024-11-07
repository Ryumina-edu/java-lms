package nextstep.courses.domain.session.entity;

import java.time.LocalDateTime;

public class SessionEntity {
    private final Long id;

    private final String title;

    private final Long creatorId;

    private final String status;

    private final long price;

    private final String payType;

    private final int maxStudentCount;

    private final String coverImage;

    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    public SessionEntity(String title,
                         Long creatorId,
                         String status,
                         long price,
                         String payType,
                         int maxStudentCount,
                         String coverImage,
                         LocalDateTime startDateTime,
                         LocalDateTime endDateTime) {
        this(0L, title, creatorId, status, price, payType, maxStudentCount, coverImage, startDateTime, endDateTime);
    }

    public SessionEntity(Long id,
                         String title,
                         Long creatorId,
                         String status,
                         long price,
                         String payType,
                         int maxStudentCount,
                         String coverImage,
                         LocalDateTime startDateTime,
                         LocalDateTime endDateTime) {
        this.id = id;
        this.title = title;
        this.creatorId = creatorId;
        this.status = status;
        this.price = price;
        this.payType = payType;
        this.maxStudentCount = maxStudentCount;
        this.coverImage = coverImage;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public String getStatus() {
        return status;
    }

    public long getPrice() {
        return price;
    }

    public String getPayType() {
        return payType;
    }

    public int getMaxStudentCount() {
        return maxStudentCount;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    @Override
    public String toString() {
        return "SessionEntity{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", creatorId=" + creatorId +
            ", status='" + status + '\'' +
            ", price=" + price +
            ", payType='" + payType + '\'' +
            ", maxStudentCount=" + maxStudentCount +
            ", coverImage='" + coverImage + '\'' +
            ", startDateTime=" + startDateTime +
            ", endDateTime=" + endDateTime +
            '}';
    }
}
