package xmu.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.demo.domain.Goods;

@Mapper
public interface GoodsMapper {
     Goods findById(Integer id);
     int create(Goods goods);

}
