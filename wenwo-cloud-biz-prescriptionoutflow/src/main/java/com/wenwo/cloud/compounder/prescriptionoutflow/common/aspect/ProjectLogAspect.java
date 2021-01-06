package com.wenwo.cloud.compounder.prescriptionoutflow.common.aspect;

import com.wenwo.cloud.compounder.prescriptionoutflow.common.constans.ProjectConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Set;

/**
 * 切片方式记录日志
 * 注意，execution中的包路径！
 *
 * @author wenwo
 * @date 2020/08/11
 */
@Component
@Aspect
@Slf4j
public class ProjectLogAspect {

    /**
     * 类名分隔符
     */
    private final static String classNameSep = "$";

    /**
     * Service层忽略的方法集合：元素格式——类名.方法名
     */
    private final static Set<String> ignoredServiceFunctionSet = Collections.emptySet(
        // 留空，开发者自定义 改为 Collections.unmodifiableSet
    );

    /**
     * 控制器层controller中所有方法的日志
     */
    @Before("execution(* com.wenwo.cloud.compounder.prescriptionoutflow.controller..*.*(..))")
    public void controllerLog(JoinPoint jp) {
        // 获取请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("请求URL：{}，请求地址：{}，xForwardedFor：{}，xRealIp：{}",
            request.getRequestURL(), request.getRemoteAddr(),
            request.getHeader(ProjectConstant.REQUEST_HEADER_X_FORWARDED_FOR),
            request.getHeader(ProjectConstant.REQUEST_HEADER_X_REAL_IP));
    }

    /**
     * 服务层service包下的public方法
     * 结合ignoredServiceFunctionSet忽略一些方法的日志
     */
    @Around("execution(public * com.wenwo.cloud.compounder.prescriptionoutflow.service..*.*(..))")
    public Object serviceLog(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch clock = new StopWatch();

        // 计时开始
        clock.start();

        String className = pjp.getThis().getClass().getSimpleName();
        int idx = className.indexOf(classNameSep);
        if (-1 != idx) {
            className = className.substring(0, idx);
        }

        String methodName = pjp.getSignature().getName();

        Object[] objs = pjp.getArgs();

        Object result = pjp.proceed();

        // 计时结束
        clock.stop();

        // 不显示函数执行后的结果（要么很多，要么包含机密信息）

        String classMethodFmt = "%s.%s";
        String classMethod = String.format(classMethodFmt, className, methodName);
        if (ignoredServiceFunctionSet.contains(classMethod)) {
            // 不输出参数到日志
            log.info("方法执行正常 {}，执行时间：{} 毫秒", classMethod, clock.getTotalTimeMillis());
        } else {
            log.info("方法执行正常 {}，执行时间：{} 毫秒，参数：{}", classMethod, clock.getTotalTimeMillis(), objs);
        }

        return result;
    }
}
