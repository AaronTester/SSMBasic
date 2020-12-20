package com.aaron.util;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/5
 */


import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.aaron.annotation.Log;
import com.aaron.pojo.SystemLog;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP实现日志
 *
 * @author liqiang
 */
@Component
@Aspect
public class LogAopAspect {
/*
    //@Autowired
    //private SystemLogService systemLogService;

    private static Logger logger = Logger.getLogger(LogAopAspect.class);

    private static final String ip;
    private static final String currentUser;

    static {
        ip = "127.0.0.1";
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        currentUser = computerName + "-" + userName;
    }

    @Pointcut("execution (* com.aaron.controller.*.*(..))")
    public void controllerAspect() {
    }
    @Pointcut("execution (* com.aaron.service.*.*(..))")
    public void serviceAspect() {
    }

    // 组合以上所有切入点
    @Pointcut("controllerAspect()||serviceAspect()")
    public void allPoints() {
    }
    *//**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     *//*
    @Before("allPoints()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==========执行controller前置通知===============");
        if (logger.isInfoEnabled()) {
            logger.info("before " + joinPoint);
        }
    }

    //配置controller环绕通知,使用在方法aspect()上注册的切入点
    @Around("allPoints()")
    public void around(JoinPoint joinPoint) {
        System.out.println("==========开始执行controller环绕通知===============");
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            if (logger.isInfoEnabled()) {
                logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            }
            System.out.println("==========结束执行controller环绕通知===============");
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            if (logger.isInfoEnabled()) {
                logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            }
        }
    }

    *//**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     *//*
    @After("allPoints()")
    public void after(JoinPoint joinPoint) {
        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operationName = method.getAnnotation(Log.class).operationName();
                        break;
                    }
                }
            }
            System.out.println("=====controller后置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()") + "." + operationType);
            System.out.println("方法描述:" + operationName);
            System.out.println("请求人:" + currentUser);
            System.out.println("请求IP:" + ip);
            SystemLog log = new SystemLog();
            log.setId(UUID.randomUUID().toString());
            log.setDescription(operationName);
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()") + "." + operationType);
            log.setLogType((long) 0);
            log.setRequestIp(ip);
            log.setExceptioncode(null);
            log.setExceptionDetail(null);
            log.setParams(null);
            log.setCreateBy(currentUser);
            log.setCreateDate(new Date());
            //保存数据库
            //systemLogService.insert(log);
            logger.info(log.toString());
            System.out.println("=====controller后置通知结束=====");
        } catch (Exception e) {
            //记录本地异常日志
            logger.error("==后置通知异常==");
            logger.error("异常信息:{}" + e.getMessage(), e);
        }
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning("allPoints()")
    public void afterReturn(JoinPoint joinPoint) {
        System.out.println("=====执行controller后置返回通知=====");
        if (logger.isInfoEnabled()) {
            logger.info("afterReturn " + joinPoint);
        }
    }

    *//**
     * 异常通知 用于拦截记录异常日志
     *
     * @param joinPoint
     * @param e
     *//*
    @AfterThrowing(pointcut = "allPoints()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params += JSON.toJSONString(joinPoint.getArgs()[i]) + ";";
            }
        }
        try {

            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(Log.class).operationType();
                        operationName = method.getAnnotation(Log.class).operationName();
                        break;
                    }
                }
            }
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()") + "." + operationType);
            System.out.println("方法描述:" + operationName);
            System.out.println("请求人:" + currentUser);
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
            SystemLog log = new SystemLog();
            log.setId(UUID.randomUUID().toString());
            log.setDescription(operationName);
            log.setExceptioncode(e.getClass().getName());
            log.setLogType((long) 1);
            log.setExceptionDetail(e.getMessage());
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setParams(params);
            log.setCreateBy(currentUser);
            log.setCreateDate(new Date());
            log.setRequestIp(ip);
            //保存数据库
            //systemLogService.insert(log);
            logger.info(log.toString());
            System.out.println("=====异常通知结束=====");
        } catch (Exception ex) {
            //记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}" + ex.getMessage(), ex);
        }
        logger.error("异常方法:" + joinPoint.getTarget().getClass().getName() + " 异常代码:" + joinPoint.getSignature().getName() + " 异常信息:" + e.getMessage() + "参数:" + params);

    }*/
}
