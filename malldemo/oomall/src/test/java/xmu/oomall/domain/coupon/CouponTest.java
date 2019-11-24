package xmu.oomall.domain.coupon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    private Coupon coupon;

    @BeforeEach
    void setUp(){
        CouponRulePo realObj = new CouponRulePo();
        realObj.setStrategy("{\"name\":\"xmu.oomall.domain.coupon.CashOffStrategy\", \"obj\":{\"threshold\":100.01, \"offCash\":10.01}}");
        realObj.setGoodsIds("{\"gIDs\":[1,2,3]}");
        CouponRule couponRule = new CouponRule(realObj);
        this.coupon = new Coupon();
        this.coupon.setCouponRule(couponRule);
        this.coupon.setBeginTime(LocalDateTime.now().minusDays(1));
        this.coupon.setEndTime((LocalDateTime.now().plusDays(1)));
        this.coupon.setStatus(Coupon.Status.NOT_USED.getValue());
    }

    @Test
    void isReadyToUse() {
        assertTrue(this.coupon.isReadyToUse());

        LocalDateTime time = this.coupon.getEndTime();
        this.coupon.setEndTime((LocalDateTime.now().minusDays(1)));
        assertFalse(this.coupon.isReadyToUse());
        this.coupon.setEndTime(time);

        time = this.coupon.getBeginTime();
        this.coupon.setBeginTime(LocalDateTime.now().plusDays(1));
        assertFalse(this.coupon.isReadyToUse());
        this.coupon.setBeginTime(time);

    }

    @Test
    void cacuCouponPrice() {
    }
}