package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmu.oomall.controller.vo.OrderSubmitVO;
import xmu.oomall.domain.*;
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
     * @param body   订单信息，{ cartId：xxx, addressId: xxx, couponId: xxx, message: xxx, grouponRulesId: xxx,  grouponLinkId: xxx}
     * @return 提交订单操作结果
     */
    @PostMapping("")
    public Object submit(@RequestBody OrderSubmitVO submitVO) {

        //例子代码中把用户id强制设定为1
        User user = new User();
        user.setId(1);
        //**************

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setAddress(submitVO.getAddress());
        ACoupon aCoupon = couponService.findACouponById(submitVO.getACoupon_id());
        if (null != aCoupon){
            newOrder.setCoupon(aCoupon);
        }

        List<CartItem> cartItems = new ArrayList<CartItem>(submitVO.getCartItem_ids().size())
        for (Integer cartId: submitVO.getCartItem_ids() ){
            cartItems.add(goodsService.findCartItemById(cartId));
        }
        GroupOnRule groupOnRule = goodsService.findGroupOnRuleById(submitVO.getGroupOnRule_id());

        if (groupOnRule.isExpired()){

        }

        return orderService.submit(newOrder, cartItems, groupOnRule);
    }
}