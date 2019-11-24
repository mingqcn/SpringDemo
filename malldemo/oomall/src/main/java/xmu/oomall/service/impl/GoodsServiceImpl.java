package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.mapper.CartItemMapper;
import xmu.oomall.service.GoodsService;

import java.util.List;

/**
 * @author: Ming Qiu
 * @description:商品服务的实现
 * @date: Created in 15:50 2019/11/24
 * @modified By:
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CartItemMapper cartItemMapper;

    @Override
    public CartItem findCartItemById(Integer id) {
        return cartItemMapper.findCartItemById(id);
    }

    @Override
    public void clearCartItem(List<CartItem> cartItems) {
        cartItemMapper.clearCartItem(cartItems);
    }
}
