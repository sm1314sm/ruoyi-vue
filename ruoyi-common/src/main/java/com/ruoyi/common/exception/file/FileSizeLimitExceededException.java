package com.ruoyi.common.exception.file;

/**
 * 文件名大小限制异常类
 */
public class FileSizeLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    /**
     * 调用父类的构造方法 定义异常code为upload.exceed.maxSize 一个参数为defaultMaxSize
     * @param defaultMaxSize
     */
    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("upload.exceed.maxSize", new Object[]{defaultMaxSize});
    }
}
