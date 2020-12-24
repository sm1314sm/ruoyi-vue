package com.ruoyi.common.exception.user;

/**
 * 验证码失效异常类
 */
public class CaptchaExpireException extends UserException {
    private static final long serialVersionUID = 1L;

    /**
     * 调用父类构造方法 定义异常code为user.jcaptcha.expire 参数为null
     */
    public CaptchaExpireException() {
        super("user.jcaptcha.expire", null);
    }
}
