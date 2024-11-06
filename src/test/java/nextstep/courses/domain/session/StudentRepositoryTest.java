package nextstep.courses.domain.session;

import nextstep.courses.domain.session.entity.StudentEntity;
import nextstep.courses.infrastructure.CourseRepositoryTest;
import nextstep.courses.infrastructure.JdbcStudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@JdbcTest
class StudentRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryTest.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new JdbcStudentRepository(jdbcTemplate);
    }

    @Test
    void crud() {
        StudentEntity studentEntity = new StudentEntity(3L, 1L);

        int count = studentRepository.save(studentEntity);
        Assertions.assertThat(count).isEqualTo(1);

        List<StudentEntity> students = studentRepository.findBySessionId(1L);
        Assertions.assertThat(students.size()).isEqualTo(3);
    }
}