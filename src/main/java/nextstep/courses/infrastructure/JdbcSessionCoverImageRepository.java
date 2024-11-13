package nextstep.courses.infrastructure;

import nextstep.courses.domain.session.entity.SessionCoverImageEntity;
import nextstep.courses.domain.session.sessioncoverimage.SessionCoverImage;
import nextstep.courses.domain.session.sessioncoverimage.SessionCoverImageRepository;
import nextstep.qna.NotFoundException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("sessionCoverImageRepository")
public class JdbcSessionCoverImageRepository implements SessionCoverImageRepository {
    private final SessionCoverImageRowMapper SESSION_COVER_IMAGE_ROW_MAPPER = new SessionCoverImageRowMapper();

    private final JdbcOperations jdbcTemplate;

    public JdbcSessionCoverImageRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SessionCoverImage findById(long coverImageId) {
        String sql = "select id, session_id, image_type, width, height, size from cover_image where id = ?";

        SessionCoverImageEntity sessionCoverImageEntity = Optional.ofNullable(jdbcTemplate.queryForObject(sql,
                                                                                                          SESSION_COVER_IMAGE_ROW_MAPPER,
                                                                                                          coverImageId))
                                                                  .orElseThrow(NotFoundException::new);

        return sessionCoverImageEntity.toSessionCoverImage();
    }

    @Override
    public List<SessionCoverImage> findBySessionId(long sessionId) {
        String sql = "select cover_image.id, cover_image.session_id, cover_image.image_type, " +
            "cover_image.width, cover_image.height, cover_image.size " +
            "from cover_image, session " +
            "where cover_image.session_id = session.id " +
            "and session_id = ?";

        List<SessionCoverImageEntity> sessionCoverImageEntities = Optional.ofNullable(jdbcTemplate.query(sql,
                                                                                                         SESSION_COVER_IMAGE_ROW_MAPPER,
                                                                                                         sessionId))
                                                                          .orElseThrow(NotFoundException::new);

        return sessionCoverImageEntities.stream()
                                        .map(SessionCoverImageEntity::toSessionCoverImage)
                                        .collect(Collectors.toList());
    }

    private class SessionCoverImageRowMapper implements RowMapper<SessionCoverImageEntity> {
        @Override
        public SessionCoverImageEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new SessionCoverImageEntity(
                rs.getLong("id"),
                rs.getLong("session_id"),
                rs.getString("image_type"),
                rs.getInt("width"),
                rs.getInt("height"),
                rs.getLong("size"));
        }
    }
}
