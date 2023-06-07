package Aop.Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)////Порядок выполнения аспектов- все аспекты в этом классе будут выполняться перед аспектами класса ASPECT
public class PointCutFromMyPointCut {
    @Before("Aop.Aspects.MyPointCut.allReturnMethodsSlibraly()")// тут используем поинткат который лежит в классе MyPointCut
    public void     beforeReturnLoggingAdvice () {
        System.out.println("ПОИНТ КАТ из другого класса");
    }
}
