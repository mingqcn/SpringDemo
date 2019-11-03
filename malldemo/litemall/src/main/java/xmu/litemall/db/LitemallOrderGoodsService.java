package xmu.litemall.db;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Service;
import xmu.litemall.dao.LitemallOrderGoodsMapper;
import xmu.litemall.domain.LitemallOrderGoods;

import java.time.LocalDateTime;

@Service
public class LitemallOrderGoodsService {
    @Mapper
    private LitemallOrderGoodsMapper orderGoodsMapper;

    public int add(LitemallOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

}
