package com.ruoyi.common.exception.file;

/**
 * 文件名称超长限制异常类
 */
public class FileNameLengthLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    /**
     * 调用父类的构造方法 定义异常code为upload.filename.exceed.length 一个参数为defaultFileNameLength
     */
    public FileNameLengthLimitExceededException(int defaultFileNameLength) {
        super("upload.filename.exceed.length", new Object[]{defaultFileNameLength});
    }
}
