package Aop.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;

@Component
@Aspect
public class AroundAnnotationExpl {//проверка работы аннотации Around
@Pointcut(value = "execution(public String returnAround() )")
public void aroundPointCut(){

}
 /** Аннотация @Around выполняет код до выполнения метода бизнес логики и после,НО при работе с ним необходимо в ручную
  *  внутри Адвайса запускать метод бизнес логики- см ниже как это делается. Результат работы метода бизнеслогики
  *  перехватывается этим адвайсом и необходимо его прокинуть (return) вперед- в место где бизнес логический метод был вызвон**/
//proceedingJoinPoint -это как бы точка выполнения таргет метода(метода бизнес логики) когда мы знаем результат выполнения метода, но еще не завершили его выполнения
 //Чем он отличается от JoinPoint хитрожопый Заур не сказал
    @Around(value = "aroundPointCut()")// тут пишет аннотация и поинт кат - все как обычно
    public Object aroundLoggingAdvice (ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // вот тут возвращается Object,
        // тк ниже результат работы метода .proceed- это Object- то есть мы возвращаем этим адвайсом результат
        // метода бизнес логики returnAround()
        //throws Throwable ставится потому что .Proceed может кидать проверяемые исключения и их надо либо тут обрабатывать либо прокидывать
        System.out.println("начало работы Адвайса @Around");
        long begin=System.currentTimeMillis();// просто фишка как засечь время выполнения метода
       Object targetMethodResult= proceedingJoinPoint.proceed();// тут пролучаем из proceedingJoinPoint методом
        long end=System.currentTimeMillis();// можно от end вычесть begin и получим время работы таргет метода
        // proceed() результат метода returnAround и записываем в Object

        System.out.println("конец работы Адвайса @Around");
        return targetMethodResult;//так же как и с аннотацией After мжно подложить результат выполнения таргет метода любым другим результатом
    }

    //логика работы с этой аннотации в том что в месте где "начало работы адвайса " мы можем выполнить первую часть логики , например проверку доступа,а
    //а потом вы делаем таргет метод , запоминаем его результата, и делаем вторую часть адвайса-"конец работы Адвайса" и потом возвращаем результат
    // то есть метод сочитает в себе 3 в 1
//тут можно обработать исключения , но мне кажется это херовый вариант
}
