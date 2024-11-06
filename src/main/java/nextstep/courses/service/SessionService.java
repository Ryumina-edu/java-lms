package nextstep.courses.service;

import nextstep.courses.domain.session.SessionRepository;
import nextstep.courses.domain.session.StudentRepository;
import nextstep.courses.domain.session.entity.SessionEntity;
import nextstep.courses.domain.session.entity.StudentEntity;
import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sessionService")
public class SessionService {
    private final SessionRepository sessionRepository;

    private final StudentRepository studentRepository;

    public SessionService(SessionRepository sessionRepository, StudentRepository studentRepository) {
        this.sessionRepository = sessionRepository;
        this.studentRepository = studentRepository;
    }

    public void enroll(long sessionId, NsUser student, Payment payment) {
        SessionEntity sessionEntity = sessionRepository.findById(sessionId);

        List<StudentEntity> students = studentRepository.findBySessionId(sessionId);

//        todo: SessionEntity -> Session / StudentEntity -> Student 변환 작업
//        Session session = sessionEntity.toSession(students);
//        session.enroll(student, payment);

//        todo: Session -> SessionEntity / Student -> StudentEntity 변환 작업

//        sessionRepository.save(sessionEntity);
//        studentRepository.save(studentEntity);
    }

}
