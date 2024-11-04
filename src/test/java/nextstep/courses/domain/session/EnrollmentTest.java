package nextstep.courses.domain.session;

import nextstep.courses.CannotApplyException;
import nextstep.users.domain.NsUser;
import nextstep.users.domain.NsUserTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class EnrollmentTest {

    @Test
    void enroll_정상케이스() {
        NsUser user1 = NsUserTest.JAVAJIGI;
        NsUser user2 = NsUserTest.SANJIGI;

        Students students = new Students(10);

        Enrollment enrollment = new Enrollment(Status.RECRUIT, students);

        enrollment.enroll(user1);
        enrollment.enroll(user2);

        Assertions.assertThat(students.countOfStudent()).isEqualTo(2);
    }

    @Test
    @DisplayName("현재 모집중인 강의가 아니라면 CannotApplyException이 발생한다.")
    void enroll_모집중인_강의가_아닌_경우() {
        NsUser user1 = NsUserTest.JAVAJIGI;
        NsUser user2 = NsUserTest.SANJIGI;
        Students students = new Students(10, Arrays.asList(user1, user2));

        Enrollment enrollment = new Enrollment(Status.PREPARE, students);

        NsUser newUser = new NsUser(3L, "mina", "password", "name", "mina@test.com");

        Assertions.assertThatThrownBy(() -> {
            enrollment.enroll(newUser);
        }).isInstanceOf(CannotApplyException.class);
    }

}
