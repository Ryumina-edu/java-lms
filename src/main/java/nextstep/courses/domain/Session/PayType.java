package nextstep.courses.domain.Session;

public enum PayType {
    FREE, PAY;

    public void isValid(long price) {
        if (isFree() && price > 0) {
            throw new IllegalArgumentException("무료 강의는 0원이어야 합니다.");
        }

        if (!isFree() && price == 0) {
            throw new IllegalArgumentException("유료 강의는 0원 이상이어야 합니다.");
        }
    }

    private boolean isFree() {
        return this == FREE;
    }
}
