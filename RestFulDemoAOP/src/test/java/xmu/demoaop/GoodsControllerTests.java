package xmu.demoaop;

import com.alibaba.fastjson.JSON;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import xmu.demoaop.controller.vo.LoginVo;
import xmu.demoaop.domain.Goods;
import xmu.demoaop.util.JacksonUtil;
import xmu.demoaop.util.ResponseCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DemoAopApplication.class)
@AutoConfigureMockMvc
public class GoodsControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDetailTest() throws Exception {
        this.mvc.perform(get("/wx/goods/1/detail"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).
                andExpect(content().json("{\"errno\":0,\"data\":{\"id\":1,\"goodsSn\":\"111111\"," +
                        "\"name\":\"测试商品\",\"categoryId\":null,\"brandId\":null,\"gallery\":null,\"keywords\":null,\"brief\":null," +
                        "\"isOnSale\":null,\"sortOrder\":null,\"picUrl\":null,\"shareUrl\":null,\"isNew\":null,\"isHot\":true,\"unit\":null," +
                        "\"counterPrice\":null,\"retailPrice\":null,\"addTime\":null,\"updateTime\":null,\"deleted\":null,\"detail\":null," +
                        "\"goodsAttributeList\":[{\"id\":null,\"goodsId\":null,\"attribute\":\"属性1\",\"value\":\"值1\",\"addTime\":null," +
                        "\"updateTime\":null,\"deleted\":null},{\"id\":null,\"goodsId\":null,\"attribute\":\"属性2\",\"value\":\"值2\"," +
                        "\"addTime\":null,\"updateTime\":null,\"deleted\":null}],\"goodsSpecificationList\":[{\"id\":null,\"goodsId\":null," +
                        "\"specification\":\"规格1\",\"value\":\"规格值1\",\"picUrl\":null,\"addTime\":null,\"updateTime\":null," +
                        "\"deleted\":null},{\"id\":null,\"goodsId\":null,\"specification\":\"规格2\",\"value\":\"规格值2\"," +
                        "\"picUrl\":null,\"addTime\":null,\"updateTime\":null,\"deleted\":null}]},\"errmsg\":\"成功\"}"));
    }

    @Test
    public void searchTest() throws Exception {

        this.mvc.perform(get("/wx/goods/search?name=墨迹"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).
                andExpect(content().json("{\"errno\":0,\"data\":{\"id\":0,\"goodsSn\":\"111111\"," +
                        "\"name\":\"墨迹\",\"categoryId\":null,\"brandId\":null,\"gallery\":null,\"keywords\":null,\"brief\":null," +
                        "\"isOnSale\":null,\"sortOrder\":null,\"picUrl\":null,\"shareUrl\":null,\"isNew\":null,\"isHot\":true,\"unit\":null," +
                        "\"counterPrice\":null,\"retailPrice\":null,\"addTime\":null,\"updateTime\":null,\"deleted\":null,\"detail\":null," +
                        "\"goodsAttributeList\":[{\"id\":null,\"goodsId\":null,\"attribute\":\"属性1\",\"value\":\"值1\",\"addTime\":null," +
                        "\"updateTime\":null,\"deleted\":null},{\"id\":null,\"goodsId\":null,\"attribute\":\"属性2\",\"value\":\"值2\"," +
                        "\"addTime\":null,\"updateTime\":null,\"deleted\":null}],\"goodsSpecificationList\":[{\"id\":null,\"goodsId\":null," +
                        "\"specification\":\"规格1\",\"value\":\"规格值1\",\"picUrl\":null,\"addTime\":null,\"updateTime\":null," +
                        "\"deleted\":null},{\"id\":null,\"goodsId\":null,\"specification\":\"规格2\",\"value\":\"规格值2\"," +
                        "\"picUrl\":null,\"addTime\":null,\"updateTime\":null,\"deleted\":null}]},\"errmsg\":\"成功\"}"));

    }

    @Test
    public void createGoodTest() throws Exception {
        Goods g = new Goods();
        g.setId(1);
        g.setGoodsSn("111111");
        g.setIsHot(true);
        g.setName("测试商品");

        String goodJson = JSON.toJSONString(g);

        String responseString = this.mvc.perform(post("/wx/goods").contentType("application/json;charset=UTF-8").content(goodJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).
                andReturn().getResponse().getContentAsString();

        String errMsg = JacksonUtil.parseObject(responseString, "errmsg", String.class);
        Integer errNo = JacksonUtil.parseObject(responseString, "errno", Integer.class);

        assertEquals(ResponseCode.AUTH_NEED_LOGIN, errNo);
   }
    @Test
    public void createGoodTest2() throws Exception {
        Goods g = new Goods();
        g.setId(1);
        g.setGoodsSn("111111");
        g.setIsHot(true);
        g.setName("测试商品");

        String goodJson = JSON.toJSONString(g);

        String responseString = this.login("4","hello");
        String token = JacksonUtil.parseObject(responseString,"data", String.class);
        System.out.println("11token = "+token);
        this.mvc.perform(post("/wx/goods")
                .header("authorization",token)
                .contentType("application/json;charset=UTF-8")
                .content(goodJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).
                andExpect(content().json("{\"errno\":0,\"data\":{\"id\":1,\"goodsSn\":\"111111\"," +
                        "\"name\":\"测试商品\",\"categoryId\":null,\"brandId\":null,\"gallery\":null,\"keywords\":null,\"brief\":null," +
                        "\"isOnSale\":null,\"sortOrder\":null,\"picUrl\":null,\"shareUrl\":null,\"isNew\":null,\"isHot\":true,\"unit\":null," +
                        "\"counterPrice\":null,\"retailPrice\":null,\"addTime\":null,\"updateTime\":null,\"deleted\":null,\"detail\":null," +
                        "\"goodsAttributeList\":null,\"goodsSpecificationList\":null},\"errmsg\":\"成功\"}"));

    }

    private String login(String userName, String password) throws Exception{
        LoginVo loginVo = new LoginVo();
        loginVo.setUserName(userName);
        loginVo.setPassword(password);
        String jsonString = JacksonUtil.toJson(loginVo);
        String responseString = this.mvc.perform(post("/user/login").contentType("application/json;charset=UTF-8").content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        return responseString;
    }
}
