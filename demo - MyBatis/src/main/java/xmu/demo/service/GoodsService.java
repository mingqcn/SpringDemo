package xmu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.demo.domain.Goods;
import xmu.demo.mapper.GoodsMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 获取某个商品信息，仅展示相关内容
     *
     * @param id
     * @return
     */
    public Goods findById(Integer id) {
        return goodsMapper.findById(id);
    }

    public Goods create(Goods goods) {
        goodsMapper.create(goods);
        return goods;
    }
}
