package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.coupon.Coupon;
import xmu.oomall.domain.coupon.CouponRule;
import xmu.oomall.domain.coupon.CouponRulePo;

/**
 * @Author: Ming Qiu
 * @Description:优惠卷Mapper接口
 * @Date: Created in 11:03 2019/11/19
 * @Modified By:
 **/

@Mapper
public interface CouponMapper {

    public Coupon findCouponById(Integer id);

    public CouponRulePo findCouponRuleById(Integer id);
}
