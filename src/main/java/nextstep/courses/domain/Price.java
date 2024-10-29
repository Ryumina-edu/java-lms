package nextstep.courses.domain;

import nextstep.payments.domain.Payment;

public class Price {
    private long price;

    public Price(long price) {
        this.price = price;
    }

    public boolean isSame(Payment payment) {
        return price == payment.getAmount();
    }
}
