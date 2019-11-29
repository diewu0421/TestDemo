package com.example.aopdemo.aspectj;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019-08-14 00:06
 */
@Aspect
public class TestAspectj {
    
    @Pointcut("execution(* com.example.aopdemo.BaseNetTools.getUrl(..))")
    public void getUrl() {}
    
    @Around("getUrl()")
    public Object beforeGetUrl(ProceedingJoinPoint point) throws Throwable {
        Log.e("TestAspectj", "beforeGetUrl: ");
        Object[] args = point.getArgs();
        args[0] = args[0] + "zenglw";
        return point.proceed(args);

        
    }

    @AfterThrowing(value = "getUrl()", throwing = "throwable")
    public void exception(Throwable throwable) {
        Log.e("TestAspectj", "exception: ");
    }
}
