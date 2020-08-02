package xmu.demoaop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import xmu.demoaop.model.ObjectType;
import xmu.demoaop.util.*;
import xmu.demoaop.model.UserPo;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther mingqiu
 * @date 2020/6/26 下午2:59
 */
@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public Object login(String userName, String password, Integer userType) {
        if (userName.equals("1")) {
            return ResponseUtil.fail(ResponseCode.AUTH_INVALID_ACCOUNT, ResponseCode.AUTH_INVALID_ACCOUNT_MSG);
        }

        logger.info("login: userName = " + userName);
        if (userName.equals("2")) {
            return ResponseUtil.fail(ResponseCode.AUTH_USER_FORBIDDEN, ResponseCode.AUTH_USER_FORBIDDEN_MSG);
        }

        if (userName.equals("3")) {
            return ResponseUtil.fail(ResponseCode.AUTH_USER_UNAUTH, ResponseCode.AUTH_USER_UNAUTH_MSG);
        }
        logger.info("login: userName = " + userName+" password = "+password);

        if (!password.equals("hello")) {
            return ResponseUtil.fail(ResponseCode.AUTH_INVALID_ACCOUNT, ResponseCode.AUTH_INVALID_ACCOUNT_MSG);
        }

        String token = new JwtHelper().createToken(Integer.parseInt(userName));

        return ResponseUtil.ok(token);
    }

    public List<UserPo> findUserById(Integer userId) {
        UserPo user = new UserPo();
        user.setId(userId);
        user.setUserType(ObjectType.USER_ADMIN);
        if (userId == 2) {
            user.setForbid(true);
        }
        if (userId == 3) {
            user.setAuthorized(false);
        }
        List<UserPo> userList= new ArrayList<UserPo>();
        if (userId != 1) {
            userList.add(user);
        }
        return  userList;
    }
}