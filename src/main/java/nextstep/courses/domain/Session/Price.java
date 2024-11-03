package nextstep.courses.domain.Session;

import nextstep.payments.domain.Payment;

public class Price {
    private long price;

    private PayType payType;

    public Price(long price, PayType payType) {
        payType.isValid(price);
        this.price = price;
        this.payType = payType;
    }

    public boolean isSame(Payment payment) {
        return price == payment.getAmount();
    }
}
