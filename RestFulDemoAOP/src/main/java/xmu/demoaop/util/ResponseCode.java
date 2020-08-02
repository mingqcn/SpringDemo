package xmu.demoaop.util;

/**
 * @auther mingqiu
 * @date 2020/6/26 下午10:09
 */
public class ResponseCode {
    public static final Integer OK = 0;
    public static final String OK_MSG = "成功";

    public static final Integer AUTH_INVALID_ACCOUNT = 700;
    public static final String AUTH_INVALID_ACCOUNT_MSG = "用户名不存在或者密码错误";
    public static final Integer AUTH_ID_NOTEXIST = 701;
    public static final String AUTH_ID_NOTEXIST_MSG = "登录用户id不存在";
    public static final Integer AUTH_USER_FORBIDDEN = 702;
    public static final String AUTH_USER_FORBIDDEN_MSG = "用户被禁止登录";
    public static final Integer AUTH_USER_UNAUTH = 703;
    public static final String AUTH_USER_UNAUTH_MSG = "用户未通过审核";
    public static final Integer AUTH_NEED_LOGIN = 704;
    public static final String AUTH_NEED_LOGIN_MSG = "需要先登录";
    public static final Integer AUTH_NOT_ALLOW = 705;
    public static final String AUTH_NOT_ALLOW_MSG = "无权限访问";

    public static final Integer USER_ID_NOTEXIST = 730;
    public static final String USER_ID_NOTEXIST_MSG = "操作的用户id不存在";
    public static final Integer USER_NAME_REGISTERED = 731;
    public static final String USER_NAME_REGISTERED_MSG = "用户名重复";
    public static final Integer EMAIL_REGISTERED = 732;
    public static final String EMAIL_REGISTERED_MSG = "邮箱已被注册";





}
