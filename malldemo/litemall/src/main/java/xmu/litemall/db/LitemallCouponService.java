package xmu.litemall.db;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import xmu.litemall.dao.LitemallCouponMapper;
import xmu.litemall.dao.LitemallCouponUserMapper;
import xmu.litemall.domain.LitemallCoupon;

import javax.annotation.Resource;

@Service
public class LitemallCouponService {
    @Mapper
    private LitemallCouponMapper couponMapper;
    @Resource
    private LitemallCouponUserMapper couponUserMapper;

    private LitemallCoupon.Column[] result = new LitemallCoupon.Column[]{LitemallCoupon.Column.id, LitemallCoupon.Column.name, LitemallCoupon.Column.desc, LitemallCoupon.Column.tag,
                                            LitemallCoupon.Column.days, LitemallCoupon.Column.startTime, LitemallCoupon.Column.endTime,
                                            LitemallCoupon.Column.discount, LitemallCoupon.Column.min};


    public LitemallCoupon findById(Integer id) {
        return couponMapper.selectByPrimaryKey(id);
    }

}
