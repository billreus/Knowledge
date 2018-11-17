package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;

@Aspect //注解这是一个切面
@Component //表示这是一个bean，由Spring进行管理
public class LoggerAspect {

    //表示对这个类中的所有方法进行切面操作
    @Around(value = "execution(* basic.ProductService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }
}
