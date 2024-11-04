package nextstep.courses.domain.session;

import nextstep.courses.domain.session.sessionCoverImage.Height;
import nextstep.courses.domain.session.sessionCoverImage.Ratio;
import nextstep.courses.domain.session.sessionCoverImage.SessionCoverImage;
import nextstep.courses.domain.session.sessionCoverImage.SessionCoverImageType;
import nextstep.courses.domain.session.sessionCoverImage.Size;
import nextstep.courses.domain.session.sessionCoverImage.Width;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SessionInfoTest {

    @Test
    void create() {
        SessionCoverImageType imageType = new SessionCoverImageType("jpg");
        Width width = new Width(300);
        Height height = new Height(200);
        Ratio ratio = new Ratio(width, height);
        Size size = new Size(1_048_575L);
        SessionCoverImage sessionCoverImage = new SessionCoverImage(imageType, ratio, size);

        SessionInfo sessionInfo = new SessionInfo("강의1", sessionCoverImage, 1L);

        Assertions.assertThat(sessionInfo).isNotNull();
    }
}
