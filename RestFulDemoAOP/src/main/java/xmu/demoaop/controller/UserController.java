package xmu.demoaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmu.demoaop.controller.vo.*;
import xmu.demoaop.service.UserService;
import xmu.demoaop.model.ObjectType;

@RestController /*Restful的Controller对象*/
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public Object login(@RequestBody LoginVo userNamePassVo){
        return userService.login(userNamePassVo.getUserName(), userNamePassVo.getPassword(), ObjectType.USER_ADMIN);
    }
}
