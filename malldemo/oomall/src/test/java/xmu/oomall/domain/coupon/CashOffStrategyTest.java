package xmu.oomall.domain.coupon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.OoMallApplication;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.domain.order.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OoMallApplication.class)
class CashOffStrategyTest {

    private List<OrderItem> validItems;
    private CashOffStrategy  strategy = new CashOffStrategy();

    @BeforeEach
    void setUp() {
        this.validItems = new ArrayList<>(3);
        OrderItem item = new OrderItem();
        item.setQuantity(1);
        item.setPrice(BigDecimal.valueOf(10.01));
        Product p = new Product();
        Goods g = new Goods(1);
        p.setDesc(g);
        item.setProduct(p);
        this.validItems.add(item);

        item = new OrderItem();
        p = new Product();
        g = new Goods(2);
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(2);
        item.setPrice(BigDecimal.valueOf(20.01));
        this.validItems.add(item);

        item = new OrderItem();
        p = new Product();
        g = new Goods(3);
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(3);
        item.setPrice(BigDecimal.valueOf(30.01));
        this.validItems.add(item);

        this.strategy.setOffCash(BigDecimal.valueOf(10.01));
        this.strategy.setThreshold(BigDecimal.valueOf(50));
    }

    @Test
    void cacuDiscount() {
        List<OrderItem> newItems = this.strategy.cacuDiscount(this.validItems, "test001");

        OrderItem item = newItems.get(0);
        BigDecimal dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(9.28)));
        assertEquals(item.getPromotionSn(),"test001");

        item = newItems.get(1);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(18.58)));
        assertEquals(item.getPromotionSn(),"test001");

        item = newItems.get(2);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(27.87)));
        assertEquals(item.getPromotionSn(),"test001");
    }

    @Test
    void cacuDiscount_newItem() {
        List<OrderItem>  changedItems = this.validItems;
        OrderItem item = changedItems.get(0);
        item.setQuantity(2);

        List<OrderItem> newItems = this.strategy.cacuDiscount(this.validItems,  "test002");

        item = newItems.get(0);
        System.out.println(item);
        BigDecimal dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(9.34)));
        assertEquals(item.getPromotionSn(),"test002");

        item = newItems.get(1);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(18.68)));
        assertEquals(item.getPromotionSn(),"test002");

        item = newItems.get(2);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(28.01)));
        assertEquals(item.getPromotionSn(),"test002");

        item = newItems.get(3);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(9.33)));
        assertEquals(item.getPromotionSn(),"test002");
    }

}