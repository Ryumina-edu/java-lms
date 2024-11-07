package nextstep.courses.domain.session;

import nextstep.courses.domain.session.entity.StudentEntity;
import nextstep.courses.infrastructure.JdbcStudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@JdbcTest
class StudentRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new JdbcStudentRepository(jdbcTemplate);
    }

    @Test
    void crud() {
        StudentEntity studentEntity1 = new StudentEntity(1L, 1L);
        StudentEntity studentEntity2 = new StudentEntity(2L, 1L);

        StudentEntity studentEntity3 = new StudentEntity(3L, 2L);

        studentRepository.save(studentEntity1);
        studentRepository.save(studentEntity2);
        studentRepository.save(studentEntity3);

        List<StudentEntity> students = studentRepository.findBySessionId(1L);
        Assertions.assertThat(students.size()).isEqualTo(2);
    }
}