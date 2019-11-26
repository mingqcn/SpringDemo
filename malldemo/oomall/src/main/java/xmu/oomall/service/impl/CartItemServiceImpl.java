package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.CartItemDao;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.mapper.CartItemMapper;
import xmu.oomall.service.CartItemService;

import java.util.List;

/**
 * @author: Ming Qiu
 * @description:商品服务的实现
 * @date: Created in 15:50 2019/11/24
 * @modified By:
 **/
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemMapper cartItemMapper;

    @Autowired
    CartItemDao cartItemDao;

    @Override
    public CartItem findCartItemById(Integer id) {
        return cartItemDao.findCartItemById(id);
    }

    @Override
    public void clearCartItem(List<CartItem> cartItems) {
        cartItemMapper.clearCartItem(cartItems);
    }
}
