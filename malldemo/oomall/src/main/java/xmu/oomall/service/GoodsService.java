package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.CartItem;
import xmu.oomall.domain.GroupOnRule;

/**
 * @Author: Ming Qiu
 * @Description: 商品有关的服务
 * @Date: Created in 15:47 2019/11/5
 * @Modified By:
 **/

@Service
public interface GoodsService {

    /**
     * 用ID获得CartItem对象
     * @param id 对象ID
     * @return cartItem对象
     */
    public CartItem findCartItemById(Integer id);

    /**
     * 用ID获得GroupOnRule对象
     * @param id 对象ID
     * @return GroupOnRule对象
     */
    public GroupOnRule findGroupOnRuleById(Integer id);



}
