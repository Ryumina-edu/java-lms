package nextstep.courses.service;

import nextstep.courses.domain.session.SessionRepository;
import nextstep.courses.domain.session.StudentRepository;
import nextstep.courses.domain.session.entity.StudentEntity;
import nextstep.courses.infrastructure.JdbcSessionRepository;
import nextstep.courses.infrastructure.JdbcStudentRepository;
import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUser;
import nextstep.users.domain.UserRepository;
import nextstep.users.infrastructure.JdbcUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@JdbcTest
class SessionServiceTest {

    private SessionRepository sessionRepository;

    private StudentRepository studentRepository;

    private UserRepository userRepository;

    private SessionService sessionService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private NsUser newStudent;
    private Payment payment;

    @BeforeEach
    void setUp() {
        sessionRepository = new JdbcSessionRepository(jdbcTemplate);
        studentRepository = new JdbcStudentRepository(jdbcTemplate);
        userRepository = new JdbcUserRepository(jdbcTemplate);
        sessionService = new SessionService(sessionRepository, studentRepository, userRepository);

        newStudent = new NsUser(3L, "fbalsk8897", "password12", "ryumina", "fbalsk8897@test.com");
        payment = new Payment("3", 1L, 3L, 800_000L);
    }

    @Test
    void enroll_수강신청_성공() {
        sessionService.enroll(2L, newStudent, payment);

        List<StudentEntity> students = studentRepository.findBySessionId(2L);
        Assertions.assertThat(students.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("현재 모집중인 강의가 아닌 경우 수강신청 실패")
    void enroll_수강신청_실패() {
        Assertions.assertThatThrownBy(() -> {
            sessionService.enroll(1L, newStudent, payment);
        });
    }

}