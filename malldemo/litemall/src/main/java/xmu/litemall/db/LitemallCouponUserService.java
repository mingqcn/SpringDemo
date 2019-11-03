package xmu.litemall.db;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xmu.litemall.dao.LitemallCouponUserMapper;
import xmu.litemall.domain.LitemallCouponUser;
import xmu.litemall.domain.LitemallCouponUserExample;
import xmu.litemall.util.CouponUserConstant;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallCouponUserService {
    @Mapper
    private LitemallCouponUserMapper couponUserMapper;


    public List<LitemallCouponUser> queryList(Integer userId, Integer couponId, Short status, Integer page, Integer size, String sort, String order) {
        LitemallCouponUserExample example = new LitemallCouponUserExample();
        LitemallCouponUserExample.Criteria criteria = example.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if(couponId != null){
            criteria.andCouponIdEqualTo(couponId);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        return couponUserMapper.selectByExample(example);
    }


    public LitemallCouponUser queryOne(Integer userId, Integer couponId) {
        List<LitemallCouponUser> couponUserList = queryList(userId, couponId, CouponUserConstant.STATUS_USABLE, 1, 1, "add_time", "desc");
        if(couponUserList.size() == 0){
            return null;
        }
        return couponUserList.get(0);
    }

    public LitemallCouponUser findById(Integer id) {
        return couponUserMapper.selectByPrimaryKey(id);
    }

    public int update(LitemallCouponUser couponUser) {
        couponUser.setUpdateTime(LocalDateTime.now());
        return couponUserMapper.updateByPrimaryKeySelective(couponUser);
    }

}
