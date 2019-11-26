package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.GoodsDao;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.service.GoodsService;

/**
 * @author: Ming Qiu
 * @date: Created in 21:29 2019/11/25
 **/
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Product findProductById(Integer id) {
        return goodsDao.findProductById(id);
    }

}
