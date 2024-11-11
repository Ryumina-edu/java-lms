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
import java.util.Optional;

@Repository("sessionCoverImageRepository")
public class JdbcSessionCoverImageRepository implements SessionCoverImageRepository {
    private final SessionCoverImageRowMapper SESSION_COVER_IMAGE_ROW_MAPPER = new SessionCoverImageRowMapper();

    private final JdbcOperations jdbcTemplate;

    public JdbcSessionCoverImageRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SessionCoverImage findById(long coverImageId) {
        String sql = "select id, image_type, width, height, size from cover_image where id = ?";

        SessionCoverImageEntity sessionCoverImageEntity = Optional.ofNullable(jdbcTemplate.queryForObject(sql,
                                                                                                          SESSION_COVER_IMAGE_ROW_MAPPER,
                                                                                                          coverImageId))
                                                                  .orElseThrow(NotFoundException::new);

        return sessionCoverImageEntity.toSessionCoverImage();
    }

    private class SessionCoverImageRowMapper implements RowMapper<SessionCoverImageEntity> {
        @Override
        public SessionCoverImageEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new SessionCoverImageEntity(
                rs.getLong("id"),
                rs.getString("image_type"),
                rs.getInt("width"),
                rs.getInt("height"),
                rs.getLong("size"));
        }
    }
}
