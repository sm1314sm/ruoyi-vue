package com.ruoyi.common.utils;

/**
 * 处理并记录日志文件
 */
public class LogUtils {
    public static String getBlock(Object msg) {
        return msg == null ? "" : "[" + msg.toString() + "]";
    }
}
