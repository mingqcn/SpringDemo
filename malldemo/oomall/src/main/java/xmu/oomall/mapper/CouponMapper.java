package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.coupon.Coupon;
import xmu.oomall.domain.coupon.CouponRulePo;

/**
 * @Author: Ming Qiu
 * @Description:优惠卷Mapper接口
 * @Date: Created in 11:03 2019/11/19
 * @Modified By:
 **/

@Mapper
public interface CouponMapper {
    /**
     * 用id找一张优惠卷
     * @param id 一张优惠卷id
     * @return 优惠卷
     */
    Coupon findCouponById(Integer id);

    /**
     * 用id找优惠卷规则
     * @param id 优惠卷规则id
     * @return 优惠
     */
    CouponRulePo findCouponRuleById(Integer id);
}
