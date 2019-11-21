package xmu.oomall.domain.coupon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.domain.order.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CashOffStrategyTest {

    private List<OrderItem> validItems;
    private CashOffStrategy  strategy = new CashOffStrategy();

    @BeforeEach
    void setUp() {
        this.validItems = new ArrayList<OrderItem>(3);
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
        List<OrderItem> newItems = this.strategy.cacuDiscount(this.validItems);

        OrderItem item = newItems.get(0);
        System.out.println(item);
        BigDecimal dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(8.02)));

        item = newItems.get(1);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(16.01)));

        item = newItems.get(2);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice == null);

    }

    @Test
    void cacuDiscount_newItem() {
        List<OrderItem>  changedItems = this.validItems;
        OrderItem item = changedItems.get(0);
        item.setQuantity(2);

        List<OrderItem> newItems = this.strategy.cacuDiscount(this.validItems);

        item = newItems.get(0);
        System.out.println(item);
        BigDecimal dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(8.34)));

        item = newItems.get(1);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(16.68)));

        item = newItems.get(2);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice == null);

        item = newItems.get(3);
        System.out.println(item);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(8.35)));
    }

}