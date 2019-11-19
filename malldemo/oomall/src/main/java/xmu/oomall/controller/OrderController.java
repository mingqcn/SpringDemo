package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmu.oomall.controller.vo.OrderSubmitVo;
import xmu.oomall.domain.*;
import xmu.oomall.domain.coupon.Coupon;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.user.User;
import xmu.oomall.service.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CouponService couponService;

    /**
     * 提交订单
     *
     * @param userId 用户ID
     * @param body   订单信息，{ cartId：xxx, couponId: xxx, message: xxx, address: {XXXX}}
     * @return 提交订单操作结果
     */
    @PostMapping("")
    public Object submit(@RequestBody OrderSubmitVo submitVo) {

        //例子代码中把用户id强制设定为1
        User user = new User();
        user.setId(1);
        //**************

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setAddress(submitVo.getAddress());
        Coupon coupon = couponService.findACouponById(submitVo.getCouponId());
        if (null != coupon){
            newOrder.setCoupon(coupon);
        }

        List<CartItem> cartItems = new ArrayList<CartItem>(submitVo.getCartItemIds().size());
        for (Integer cartId: submitVo.getCartItemIds() ){
            cartItems.add(goodsService.findCartItemById(cartId));
        }

        return orderService.submit(newOrder, cartItems);
    }
}