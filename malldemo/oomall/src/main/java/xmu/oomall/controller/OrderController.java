package xmu.oomall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmu.oomall.controller.vo.OrderSubmitVo;
import xmu.oomall.domain.cart.CartItem;
import xmu.oomall.domain.coupon.Coupon;
import xmu.oomall.domain.order.Order;
import xmu.oomall.domain.user.Address;
import xmu.oomall.domain.user.User;
import xmu.oomall.service.*;
import xmu.oomall.util.ResponseUtil;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Ming Qiu
 */
@RestController
@RequestMapping(value = "/orders", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CouponService couponService;

    /**
     * 提交订单
     *
     * @param submitVo   订单信息
     * @return 提交订单操作结果
     */
    @PostMapping("")
    public Object submit(@RequestBody OrderSubmitVo submitVo) {

        logger.debug("submit参数："+submitVo);

        //例子代码中把用户id强制设定为1
        User user = new User();
        user.setId(1);
        //**************

        Address address = submitVo.getAddress();
        Order newOrder = new Order(user, address);

        Coupon coupon = couponService.findCouponById(submitVo.getCouponId());

        if (null != coupon){
            newOrder.setCoupon(coupon);
        }

        List<CartItem> cartItems = new ArrayList<CartItem>(submitVo.getCartItemIds().size());
        for (Integer cartId: submitVo.getCartItemIds() ){
            CartItem item = cartItemService.findCartItemById(cartId);
            cartItems.add(item);
        }

        Order retOrder = orderService.submit(newOrder, cartItems);

        logger.debug("submit的返回值："+retOrder);
        return ResponseUtil.ok(retOrder);
    }
}