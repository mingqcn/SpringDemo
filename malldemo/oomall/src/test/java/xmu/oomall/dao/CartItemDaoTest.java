package xmu.oomall.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.OoMallApplication;
import xmu.oomall.domain.cart.CartItem;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OoMallApplication.class)
class CartItemDaoTest {

    @Autowired
    private CartItemDao cartItemDao;

    @Test
    void findCartItemById(){
        CartItem item = cartItemDao.findCartItemById(1);
        assertEquals(item.getId(), 1);

    }
}