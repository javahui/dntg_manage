package com.lingyu.dntg.aop;

import javax.annotation.Resource;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.service.ulm.OperationLogService;
/**
 * 业务日志记录器
 * @author donghui
 */
@Component
@Aspect
public class OperationLogAOP {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Resource private OperationLogService operationLogService;
	
	private static final String expression = "execution(* com.lingyu.dntg.service..*.*_AopLog(..))";
    

//    @Before(EXP)
//    public void before(JoinPoint joinPoint) {
//        logger.info("before " + joinPoint.getSignature().getName());
//    }
//
//    @After(EXP)
//    public void after(JoinPoint joinPoint) {
//        logger.info("after " + joinPoint.getSignature().getName());
//    }

    @AfterReturning(pointcut = expression, returning = "returnVal")
    public void afterReturning(JoinPoint point, Object returnVal) {
    	String className = point.getTarget().getClass().getSimpleName();
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();
        String operatLogMethodName = StringUtils.removeEnd(methodName, "_AopLog") + StringUtils.removeEnd(className,"Service") + "Log";
        try {
			MethodUtils.invokeMethod(operationLogService, operatLogMethodName, ArrayUtils.add(args, returnVal));
		} catch (Exception e) {
			log.debug(ExceptionUtils.getMessage(e));
		}
    }
//
//    @AfterThrowing(pointcut = EXP, throwing = "e", argNames = "e")
//    public void afterThrowing(JoinPoint point, Exception e) {
//        logger.info("After Throwing " + e);
//    }

    /**
     * 统计方法调用花费时间
     * 环绕方法通知要注意必须给出调用之后的返回值,否则被代理的方法会,停止调用并返回null
     * @param point 切入点
     * @return 被代理方法的返回值
     * @throws Throwable 被代理方法的异常 
     */
    /*@Around(expression)
    public Object around(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        String clazz = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        
        stopWatch.start();
        // 调用目标对象的方法并获取返回值
        Object targetMethodReturnValue = point.proceed(point.getArgs());
        stopWatch.stop();

        log.info(clazz + "." + method + "(" + StringUtils.join(point.getArgs(),",") + ") time = " + stopWatch.getTime());

        return targetMethodReturnValue;
    }*/
   
}