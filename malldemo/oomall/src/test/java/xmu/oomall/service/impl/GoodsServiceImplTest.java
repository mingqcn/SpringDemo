package xmu.oomall.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.OoMallApplication;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.service.CartItemService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OoMallApplication.class)
class GoodsServiceImplTest {

    @Autowired
    private CartItemService goodsService;

    @Test
    void findCartItemById() {
        CartItem item = goodsService.findCartItemById(1);
        assertEquals(item.getId(),1);
        assertEquals(item.getQuantity(),2);
        assertEquals(item.getUserId(),1);
        assertEquals(item.getProduct().getId(), 1);
        assertEquals(item.getProduct().getPurchasePrice(), BigDecimal.valueOf(99));
    }

    @Test
    void clearCartItem() {
    }
}