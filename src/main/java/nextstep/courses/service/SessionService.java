package nextstep.courses.service;

import nextstep.courses.domain.session.Session;
import nextstep.courses.domain.session.SessionRepository;
import nextstep.courses.domain.session.StudentRepository;
import nextstep.courses.domain.session.entity.StudentEntity;
import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("sessionService")
public class SessionService {
    private SessionRepository sessionRepository;

    private StudentRepository studentRepository;

    public SessionService(SessionRepository sessionRepository, StudentRepository studentRepository) {
        this.sessionRepository = sessionRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void enroll(long sessionId, NsUser student, Payment payment) {
        Session session = sessionRepository.findByIdForSession(sessionId);

        session.enroll(student, payment);

        studentRepository.save(student, sessionId);
    }

    @Transactional
    public void select(long sessionId, List<Long> userIdList) {
        List<StudentEntity> selectedStudents = studentRepository.findByIdAndSessionId(sessionId, userIdList);

        Optional<Long> nonExistStudent = userIdList.stream()
                                                   .filter(userId -> !selectedStudents.stream()
                                                                                      .map(StudentEntity::getUserId)
                                                                                      .collect(Collectors.toList()).contains(userId)
                                                   )
                                                   .findAny();

        if (nonExistStudent.isPresent()) {
            throw new NoSuchElementException("[id:" + nonExistStudent.get() + "] 존재하지 않는 수강생입니다.");
        }

        studentRepository.select(sessionId, userIdList);
    }

}
