package xmu.demoaop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import xmu.demoaop.controller.vo.*;
import xmu.demoaop.util.*;

@SpringBootTest(classes = DemoAopApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login1() throws Exception {

        String responseString = this.login("1","123456");
        String errMsg = JacksonUtil.parseObject(responseString, "errmsg", String.class);
        Integer errNo = JacksonUtil.parseObject(responseString, "errno", Integer.class);
        String token = JacksonUtil.parseObject(responseString, "data", String.class);

        assertEquals(ResponseCode.AUTH_INVALID_ACCOUNT, errNo);
    }

    @Test
    public void login2() throws Exception {
        String responseString = this.login("4","hello");
        String errMsg = JacksonUtil.parseObject(responseString, "errmsg", String.class);
        Integer errNo = JacksonUtil.parseObject(responseString, "errno", Integer.class);
        String token = JacksonUtil.parseObject(responseString, "data", String.class);
        assertEquals(ResponseCode.OK, errNo);
    }

    @Test
    public void login3() throws Exception {
        String responseString = this.login("4", "12345");
        String errMsg = JacksonUtil.parseObject(responseString, "errmsg", String.class);
        Integer errNo = JacksonUtil.parseObject(responseString, "errno", Integer.class);
        String token = JacksonUtil.parseObject(responseString, "data", String.class);
        assertEquals(ResponseCode.AUTH_INVALID_ACCOUNT, errNo);
    }

    private String login(String userName, String password) throws Exception{
        LoginVo loginVo = new LoginVo();
        loginVo.setUserName(userName);
        loginVo.setPassword(password);
        String jsonString = JacksonUtil.toJson(loginVo);
        String responseString = this.mockMvc.perform(post("/user/login").contentType("application/json;charset=UTF-8").content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        return responseString;
    }
}
