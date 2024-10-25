package nextstep.qna.domain;

import nextstep.qna.CannotDeleteException;
import nextstep.users.domain.NsUser;
import nextstep.users.domain.NsUserTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    public static final Question Q1 = new Question(NsUserTest.JAVAJIGI, "title1", "contents1");
    public static final Question Q2 = new Question(NsUserTest.SANJIGI, "title2", "contents2");

    @Test
    @DisplayName("질문자와 로그인 유저가 같은 경우 질문을 삭제할 수 있다")
    void delete_질문자와_로그인_유저가_같은경우() throws CannotDeleteException {
        NsUser loginUser = NsUserTest.JAVAJIGI;

        Q1.delete(loginUser);
        Assertions.assertThat(Q1.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("질문자와 로그인 유저가 다른 경우 질문을 삭제할 수 없다")
    void delete_질문자와_로그인_유저가_다른경우() throws CannotDeleteException {
        NsUser loginUser = NsUserTest.JAVAJIGI;

        Assertions.assertThatThrownBy(() -> {
            Q2.delete(loginUser);
        }).isInstanceOf(CannotDeleteException.class);
    }
}
