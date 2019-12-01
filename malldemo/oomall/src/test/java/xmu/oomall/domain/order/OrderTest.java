package xmu.oomall.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xmu.oomall.domain.coupon.*;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.domain.user.Address;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        Order orderPo = new Order();
        List<OrderItem> items = new ArrayList<OrderItem>(5);

        OrderItem item = new OrderItem();
        item.setQuantity(1);
        item.setPrice(BigDecimal.valueOf(10.01));
        Product p = new Product();
        p.setStock(10);
        p.setRetailPrice(BigDecimal.valueOf(10.01));
        Goods g = new Goods(1);
        p.setDesc(g);
        item.setProduct(p);
        items.add(item);

        p = new Product();
        g = new Goods(2);
        item = new OrderItem();
        p.setDesc(g);
        p.setStock(10);
        p.setRetailPrice(BigDecimal.valueOf(20.01));
        item.setProduct(p);
        item.setQuantity(2);
        item.setPrice(BigDecimal.valueOf(20.01));
        items.add(item);

        p = new Product();
        g = new Goods(3);
        item = new OrderItem();
        p.setDesc(g);
        p.setStock(10);
        p.setRetailPrice(BigDecimal.valueOf(30.01));
        item.setProduct(p);
        item.setQuantity(3);
        item.setPrice(BigDecimal.valueOf(30.01));
        items.add(item);

        p = new Product();
        g = new Goods(4);
        item = new OrderItem();
        p.setStock(10);
        p.setRetailPrice(BigDecimal.valueOf(40.01));
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(4);
        item.setPrice(BigDecimal.valueOf(40.01));
        items.add(item);

        p = new Product();
        g = new Goods(5);
        item = new OrderItem();
        p.setStock(10);
        p.setRetailPrice(BigDecimal.valueOf(50.01));
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(5);
        item.setPrice(BigDecimal.valueOf(50.01));
        items.add(item);

        orderPo.setItems(items);

        CouponRulePo realObj = new CouponRulePo();
        CouponRule couponRule = new CouponRule(realObj);

        PercentageStrategy strategy = new PercentageStrategy();
        strategy.setPercentage(BigDecimal.valueOf(0.75));
        strategy.setThreshold(BigDecimal.valueOf(50));
        couponRule.setStrategy(strategy);
        List<Integer> gids = new ArrayList<>(2);
        gids.add(1);
        gids.add(2);
        couponRule.setGoodsIds(gids);

        Coupon coupon = new Coupon();
        coupon.setBeginTime(LocalDateTime.now().minusHours(1));
        coupon.setEndTime(LocalDateTime.now().plusHours(1));
        coupon.setCouponRule(couponRule);
        coupon.setCouponSn("test01");

        orderPo.setCoupon(coupon);



        this.order = orderPo;

    }

    @Test
    void cacuDealPrice() {

        order.cacuDealPrice();
        List<OrderItem> items = order.getItems();

        OrderItem item = items.get(0);
        BigDecimal dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(7.52)));
        assertEquals(items.get(0).getPromotionSn(),"test01");

        item = items.get(1);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(15.01)));
        assertEquals(item.getPromotionSn(),"test01");

        item = items.get(2);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(30.01)));
        assertEquals(item.getPromotionSn(),"");

        item = items.get(3);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(40.01)));
        assertEquals(item.getPromotionSn(),"");

        item = items.get(4);
        dealPrice = item.getDealPrice();
        assertTrue(dealPrice.equals(BigDecimal.valueOf(50.01)));
        assertEquals(item.getPromotionSn(),"");

    }

}