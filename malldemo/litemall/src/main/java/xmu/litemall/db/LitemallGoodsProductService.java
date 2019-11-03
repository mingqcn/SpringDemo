package xmu.litemall.db;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import xmu.litemall.dao.GoodsProductMapper;
import xmu.litemall.domain.LitemallGoodsProduct;
import xmu.litemall.dao.LitemallGoodsProductMapper;

@Service
public class LitemallGoodsProductService {
    @Mapper
    private LitemallGoodsProductMapper litemallGoodsProductMapper;

    @Mapper
    private GoodsProductMapper goodsProductMapper;


    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }

    public LitemallGoodsProduct findById(Integer id) {
        return litemallGoodsProductMapper.selectByPrimaryKey(id);
    }
}