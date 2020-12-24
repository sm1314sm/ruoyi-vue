package com.ruoyi.common.exception.user;

/**
 * 验证码错误异常类
 */
public class CaptchaException extends UserException {
    private static final long serialVersionUID = 1L;

    /**
     * 调用父类构造方法 定义异常code为user.jcaptcha.error 参数为null
     */
    public CaptchaException() {
        super("user.jcaptcha.error", null);
    }
}
