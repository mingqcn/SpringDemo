package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.OoMallApplication;
import xmu.oomall.domain.coupon.CashOffStrategy;
import xmu.oomall.domain.coupon.Coupon;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OoMallApplication.class)
class CouponDaoTest {
    @Autowired
    private CouponDao couponDao;

    @Test
    void findCouponById() {

        CashOffStrategy strategy = new CashOffStrategy(BigDecimal.valueOf(1000.01),BigDecimal.valueOf(10.01));

        Coupon coupon = couponDao.findCouponById(1);
        System.out.println(coupon);
        assertEquals(coupon.getId(), 1);
        assertEquals(coupon.getCouponRule().getStrategy(), strategy);
    }
}