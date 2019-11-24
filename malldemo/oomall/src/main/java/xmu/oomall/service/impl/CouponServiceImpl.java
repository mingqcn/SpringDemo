package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.CouponDao;
import xmu.oomall.domain.coupon.Coupon;

import xmu.oomall.service.CouponService;

/**
 * @Author: Ming Qiu
 * @Description:优惠卷服务的实现
 * @Date: Created in 11:03 2019/11/19
 * @Modified By:
 **/
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao couponDao;

    @Override
    public Coupon findCouponById(Integer id) {
        return couponDao.findCouponById(id);
    }
}
