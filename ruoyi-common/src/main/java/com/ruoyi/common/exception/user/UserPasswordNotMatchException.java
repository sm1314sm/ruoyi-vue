package com.ruoyi.common.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 */
public class UserPasswordNotMatchException extends UserException {
    private static final long serialVersionUID = 1L;

    /**
     * 调用父类构造方法 定义异常code为user.password.not.match 参数为null
     */
    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
