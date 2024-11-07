package nextstep.courses.infrastructure;

import nextstep.courses.domain.session.SessionRepository;
import nextstep.courses.domain.session.entity.SessionEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository("sessionRepository")
public class JdbcSessionRepository implements SessionRepository {
    private JdbcOperations jdbcTemplate;

    public JdbcSessionRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(SessionEntity sessionEntity) {
        String sql = "insert into session (title, creator_id, status, price, pay_type, max_student_count, cover_image, start_date_time, " +
            "end_date_time) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                                   sessionEntity.getTitle(),
                                   sessionEntity.getCreatorId(),
                                   sessionEntity.getStatus(),
                                   sessionEntity.getPrice(),
                                   sessionEntity.getPayType(),
                                   sessionEntity.getMaxStudentCount(),
                                   sessionEntity.getCoverImage(),
                                   sessionEntity.getStartDateTime(),
                                   sessionEntity.getEndDateTime());
    }

    @Override
    public SessionEntity findById(long sessionId) {
        String sql = "select id, title, creator_id, status, price, pay_type, max_student_count, cover_image, " +
            "start_date_time, end_date_time from session where id = ?";

        RowMapper<SessionEntity> rowMapper = (rs, rowNum) -> new SessionEntity(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getLong("creator_id"),
            rs.getString("status"),
            rs.getLong("price"),
            rs.getString("pay_type"),
            rs.getInt("max_student_count"),
            rs.getString("cover_image"),
            toLocalDateTime(rs.getTimestamp("start_date_time")),
            toLocalDateTime(rs.getTimestamp("end_date_time")));

        return jdbcTemplate.queryForObject(sql, rowMapper, sessionId);
    }

    private LocalDateTime toLocalDateTime(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return timestamp.toLocalDateTime();
    }

}