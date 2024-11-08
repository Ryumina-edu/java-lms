package nextstep.users.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<NsUser> findById(long id);

    Optional<NsUser> findByUserId(String userId);
}
