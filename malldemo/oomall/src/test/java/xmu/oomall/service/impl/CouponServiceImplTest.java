package xmu.oomall.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.OoMallApplication;
import xmu.oomall.domain.coupon.Coupon;
import xmu.oomall.service.CouponService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OoMallApplication.class)
class CouponServiceImplTest {

    @Autowired
    private CouponService couponService;

    @Test
    public void findCouponById1(){
        Coupon coupon = couponService.findCouponById(1);
        assertEquals(coupon.getId(), 1);
        assertEquals(coupon.getCouponSn(), "SF0001");
        assertEquals(coupon.getCouponRuleId(), 1);
        assertEquals(coupon.getName(), "测试优惠卷1");

        coupon = couponService.findCouponById(3);
        assertEquals(coupon.getId(), 3);
        assertEquals(coupon.getCouponSn(), "SF0003");
        assertEquals(coupon.getCouponRuleId(), 2);
        assertEquals(coupon.getName(), "测试优惠卷2");

    }
}