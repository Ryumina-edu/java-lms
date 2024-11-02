package nextstep.courses.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionCoverImageTypeTest {

    @Test
    @DisplayName("허용되는 이미지 파일 확장자가 아닌 경우 IllegalArgumentException 이 발생한다.")
    void create_허용되지_않는_확장자() {
        Assertions.assertThatThrownBy(() -> {
            SessionCoverImageType sessionCoverImageType = new SessionCoverImageType("docx");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
