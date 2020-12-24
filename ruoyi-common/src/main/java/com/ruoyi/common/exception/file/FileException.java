package com.ruoyi.common.exception.file;

import com.ruoyi.common.exception.BaseException;

/**
 * 文件信息异常类
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    /**
     * 调用父类构造方法 定义异常模块为file 异常消息为null
     *
     * @param code
     * @param args
     */
    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }
}
