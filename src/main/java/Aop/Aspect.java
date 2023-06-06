package Aop;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//аспект класс - его методы это не бизнес логика а служебные сервисы
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    //все методы внтури АОП класса называются эдвайсы-
    //есть несколько типов адвайсов
    @Before("execution(public void getB*())")// пишем перед выполнением (execution) метода getBook -
    // сделай метод ниже - Адвайс- Это выражения называется PointCut(сигнатура с аннотацией)
//*вайдкард - говорит что название может быть со словом get а потом в назании может быть что угодно
    //return type также можно менять на вайдкард - тогда метод с любым ретерн тайпом будет подходить под Адвайс
    public void beforeGetBookAdvice() {
        System.out.println("ADVICE попытка получить книгу");
    }
    @Before("execution(public void return*())")// пишем перед выполнением (execution) метода getBook -
    // сделай метод ниже - Адвайс- Это выражения называется PointCut(сигнатура с аннотацией)

    public void beforeReturnBookAdvice() {
        System.out.println("ADVICE попытка получить книгу");
    }

}
