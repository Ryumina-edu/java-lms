package nextstep.courses.domain.Session;

import java.time.LocalDateTime;

public class SessionPeriod {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public SessionPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (endDateTime.isBefore(startDateTime)) {
            throw new IllegalArgumentException("강의 종료일이 강의 시작일보다 이전일 수 없습니다.");
        }

        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
