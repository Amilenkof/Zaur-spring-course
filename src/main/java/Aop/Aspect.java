package Aop;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//аспект класс - его методы это не бизнес логика а служебные сервисы
@Component
@org.aspectj.lang.annotation.Aspect
@Order(2)//Порядок выполнения аспектов- все аспекты в этом классе будут выполняться после аспектов PointCutFromMyPointCut
public class Aspect {
    /**
     * Аннотация @PointCut и передача поинткат в другие advice
     **/
    @Pointcut("execution(public void getB*())")// пишем обший поинткат который можно будет указывать в других адвайсах
    private void allGetMethods() {

    }

    @Before("allGetMethods()")
    public void AnithingMethod() {

    }
    @Before("allGetMethods()")
    public void AnithingMethod2() {

    }
    /**все методы внтури АОП класса называются эдвайсы-**/
    /**
     * есть несколько типов адвайсов
     **/
    @Before("execution(public void getB*())")// пишем перед выполнением (execution) метода getBook -
    // сделай метод ниже - Адвайс- Это выражения называется PointCut(сигнатура с аннотацией)
//*вайдкард - говорит что название может быть со словом get а потом в назании может быть что угодно
    //return type также можно менять на вайдкард - тогда метод с любым ретерн тайпом будет подходить под Адвайс
    public void beforeGetBookAdvice() {
        System.out.println("ADVICE попытка получить книгу");
    }

    @Before("execution(public void return*())")// пишем перед выполнением (execution) метода getBook -
    // сделай метод ниже - Адвайс- Это выражения называется PointCut(сигнатура с аннотацией)
/**варианты написания PointCut**/
    public void beforeReturnBookAdvice() {
        System.out.println("ADVICE попытка получить книгу");
    }

    @Before("execution(public void *(String))")
    public void beforeAnithingMethodWithStringOnParams() {
        System.out.println("ADVICE любого метода с любым названием с параметром стринг");
    }
//    @Before("execution( void *(*))") подойдет любой метод с любым одним параметром
//    @Before("execution( void *(..))") любой метод с любым количество любых параметров
//    @Before("execution( void *(Aop.Book))") если мы передаем в указанный метод параметром обьект который сделали сами надо писать полный его адрес -имя пакета.имя класса

    /**Комбинирование pointcut**/
    //для комбинирования используются логические операторы && || !
    @Pointcut("execution(* Aop.SLibraly.get*())")
    public void allGetMethodsFromSlibraly() {

    }
    @Before("allGetMethodsFromSlibraly()")
    public void beforeGetLoggingAdvice () {
        System.out.println("beforeGetLoggingAdvice LOG 1");
    }



    @Before("Aop.Aspects.MyPointCut.allReturnMethodsSlibraly() ||allGetMethodsFromSlibraly()")
    public void retPlusGetMetodsLoggingAdvice () {
        System.out.println("allReturnMethodsSlibraly()\"+\"allGetMethodsFromSlibraly()");
    }
    //Пример для метода get выполнятся 2 АДВАЙСА allGetMethodsFromSlibraly и "allReturnMethodsSlibraly() ||allGetMethodsFromSlibraly()"
    @Pointcut("execution(* Aop.SLibraly.*(..))") // Этот поинткат выполнится на ЛЮБОМ методе в классе SLibraly с любым количество параметров
    public void allMethodsInSLibralyClass () {}
    @Pointcut("allMethodsInSLibralyClass() ?? !retPlusGetMetodsLoggingAdvice()") // вариант комбинации поинткат с отрицанием
            public void AnyMethod() {

        }



    /**JOIN POINT**///тот момент времени когда заканчивается действией АСПЕКТОВ - и начинается выполнения метода с бизнес логикой называется Join poin- Он дает возможность получить
    // параметры из сигнатуры метода и использовать их в Адвайсах

    @Before("execution (public void joinPointTest (..))")
    public void beforeJoinPointTest (JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature"+methodSignature);//  вернет = "void Aop.SLibraly.joinPointTest(String,int)"
        System.out.println("methodSignature.getMethod()"+methodSignature.getMethod());//вернет = public void Aop.SLibraly.joinPointTest(java.lang.String,int)
        System.out.println("methodSignature.getReturnType()"+methodSignature.getReturnType());//вернет = void
        System.out.println("methodSignature.getName()"+methodSignature.getName());//вернет = Параметр 1= ОКПараметр 2 = 2312


    }

    }




