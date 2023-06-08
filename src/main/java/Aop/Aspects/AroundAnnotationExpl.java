package Aop.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;

@Component
@Aspect
public class AroundAnnotationExpl {//проверка работы аннотации Around

 /** Аннотация @Around выполняет код до выполнения метода бизнес логики и после,НО при работе с ним необходимо в ручную
  *  внутри Адвайса запускать метод бизнес логики- см ниже как это делается. Результат работы метода бизнеслогики
  *  перехватывается этим адвайсом и необходимо его прокинуть (return) вперед- в место где бизнес логический метод был вызвон**/
//proceedingJoinPoint -это как бы точка выполнения таргет метода(метода бизнес логики) когда мы знаем результат выполнения метода, но еще не завершили его выполнения
 //Чем он отличается от JoinPoint хитрожопый Заур не сказал
    @Around("execution(public void returnAround() )")// тут пишет аннотация и поинт кат - все как обычно
    public Object aroundLoggingAdvice (ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // вот тут возвращается Object,
        // тк ниже результат работы метода .proceed- это Object- то есть мы возвращаем этим адвайсом результат
        // метода бизнес логики returnAround()
        //throws Throwable ставится потому что .Proceed может кидать проверяемые исключения и их надо либо тут обрабатывать либо прокидывать
        System.out.println("начало работы Адвайса @Around");

       Object targetMethodResult= proceedingJoinPoint.proceed();// тут пролучаем из proceedingJoinPoint методом
        // proceed() результат метода returnAround и записываем в Object

        System.out.println("конец работы Адвайса @Around");
        return targetMethodResult;
    }

}
