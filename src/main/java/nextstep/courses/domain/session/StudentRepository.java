package nextstep.courses.domain.session;

import nextstep.courses.domain.session.entity.StudentEntity;

import java.util.List;

public interface StudentRepository {
    int save(StudentEntity studentEntity);

    List<StudentEntity> findBySessionId(long sessionId);

}
