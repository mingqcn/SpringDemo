package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.cart.CartItem;

import java.util.List;

/**
 * @Author: Ming Qiu
 * @Description:购物车Mapper接口
 * @Date: Created in 11:03 2019/11/19
 * @Modified By:
 **/

@Mapper
public interface CartItemMapper {

    /**
     * 以id获得购物车明细
     * @param id 购物车明细ID
     * @return 购物车对象
     */
    CartItem findCartItemById(Integer id);

    /**
     * 删除购物车中指定的项目
     * @param cartItems 待删除的项目
     */
    void clearCartItem(List<CartItem> cartItems);
}
