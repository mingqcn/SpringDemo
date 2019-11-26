package xmu.oomall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import xmu.oomall.OoMallApplication;
import xmu.oomall.controller.vo.OrderSubmitVo;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.order.OrderItem;
import xmu.oomall.domain.user.Address;
import xmu.oomall.util.JacksonUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = OoMallApplication.class)
@AutoConfigureMockMvc
@Transactional
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void submit() throws Exception {

        OrderSubmitVo vo = new OrderSubmitVo();
        Address a = new Address();
        a.setCity("厦门");
        a.setProvince("福建");
        a.setName("王OO");
        a.setCounty("思明区");
        a.setAddressDetail("厦门大学海韵校区信息学院");
        a.setTel("0592-2580600");
        vo.setAddress(a);
        List<Integer> cartIds = new ArrayList<>(2);
        cartIds.add(1);
        cartIds.add(2);
        vo.setCartItemIds(cartIds);
        vo.setCouponId(1);

        String jsonString = JacksonUtil.toJson(vo);

        String responseString = this.mockMvc.perform(post("/orders").contentType("application/json;charset=UTF-8").content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();


        String errMsg = JacksonUtil.parseObject(responseString,"errmsg", String.class);
        Integer errNo = JacksonUtil.parseObject(responseString,"errno", Integer.class);
        Order order = JacksonUtil.parseObject(responseString,"data", Order.class);

        assertEquals(errNo, 0);
        assertEquals(errMsg, "成功");
        assertEquals(order.getCity(),"厦门");
        assertEquals(order.getProvince(),"福建");
        assertEquals(order.getConsignee(),"王OO");
        List<OrderItem> orderItems = order.getItems();
        assertEquals(orderItems.get(0).getPrice(), 100.01);
        assertEquals(orderItems.get(0).getDealPrice(), 100.01);
        assertEquals(orderItems.get(1).getPrice(), 100.01);
        assertEquals(orderItems.get(1).getDealPrice(), 100.01);

    }

}