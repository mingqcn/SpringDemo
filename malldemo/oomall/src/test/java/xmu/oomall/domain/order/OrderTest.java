package xmu.oomall.domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xmu.oomall.domain.coupon.CouponRule;
import xmu.oomall.domain.coupon.CouponRulePo;
import xmu.oomall.domain.goods.Goods;
import xmu.oomall.domain.goods.Product;
import xmu.oomall.domain.user.Address;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        OrderPo orderPo = new OrderPo();
        orderPo.setAddress("{\"name\":\"xmu.oomall.domain.user.Address\", \"obj\":{\"name\":\"姓名\",\"province\":\"湖南\",\"city\":\"长沙\"}}");
        List<OrderItem> items = new ArrayList<OrderItem>(5);

        OrderItem item = new OrderItem();
        item.setQuantity(1);
        item.setPrice(BigDecimal.valueOf(10.01));
        Product p = new Product();
        Goods g = new Goods(1);
        p.setDesc(g);
        item.setProduct(p);
        items.add(item);

        p = new Product();
        g = new Goods(2);
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(2);
        item.setPrice(BigDecimal.valueOf(20.01));
        items.add(item);

        p = new Product();
        g = new Goods(3);
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(3);
        item.setPrice(BigDecimal.valueOf(30.01));
        items.add(item);

        p = new Product();
        g = new Goods(4);
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(4);
        item.setPrice(BigDecimal.valueOf(40.01));
        items.add(item);

        p = new Product();
        g = new Goods(5);
        p.setDesc(g);
        item.setProduct(p);
        item.setQuantity(5);
        item.setPrice(BigDecimal.valueOf(50.01));
        items.add(item);

        orderPo.setItems(items);

        this.order = new Order(orderPo);

        CouponRulePo realObj = new CouponRulePo();
        realObj.setStrategy("{\"name\":\"xmu.oomall.domain.coupon.CashOffStrategy\", \"obj\":{\"threshold\":100.01, \"offCash\":10.01}}");
        CouponRule coupon = new CouponRule(realObj);


    }

    @Test
    void cacuDealPrice() {


    }

    @Test
    void getAddress() {
        Address a = this.order.getAddress();
        assertEquals(a.getName(), "姓名");
        assertEquals(a.getProvince(), "湖南");
        assertEquals(a.getCity(),"长沙");
    }

    @Test
    void setAddress() {
        Address a = new Address();
        a.setName("张山");
        a.setProvince("福建");
        a.setCity("厦门");
        a.setCounty("同安");
        this.order.setAddress(a);
        OrderPo realObj = this.order.getRealObj();
        assertEquals(realObj.getAddress(),"{\"obj\":{\"id\":null,\"name\":\"张山\",\"province\":\"福建\",\"city\":\"厦门\",\"county\":\"同安\",\"addressDetail\":null,\"tel\":null,\"default\":false},\"name\":\"xmu.oomall.domain.user.Address\"}");
    }
}