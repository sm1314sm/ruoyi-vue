package com.ruoyi.framework.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;

/**
 * 多数据源处理
 */
@Aspect
@Component
public class DataSourceAspect {
    /**
     * 使用了@DataSource注解的方法  @annotation(com.ruoyi.common.annotation.DataSource)
     * 使用了@DataSource注解的类的所有方法  @within(com.ruoyi.common.annotation.DataSource)
     * com.ruoyi.framework包及子包下的任意类的任意方法  execution(* com.ruoyi.framework..*.*(..))
     */
    @Pointcut("@annotation(com.ruoyi.common.annotation.DataSource)" + "|| @within(com.ruoyi.common.annotation.DataSource)")
    public void dsPointCut() {
    }

    /**
     * 环绕通知
     */
    @Around(value = "dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource dataSource = getDataSource(point);
        if (StringUtils.isNotNull(dataSource)) {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value().name());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

    /**
     * 获取需要切换的数据源
     */
    private DataSource getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (dataSource != null) {
            return dataSource;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }
}
