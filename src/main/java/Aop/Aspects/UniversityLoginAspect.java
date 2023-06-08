package Aop.Aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
/**Демонстрация работы @AFTERRETURNING**/

//AFTERRETURNING вызывает адвайсы после выполнения метода бизнес логики
@Component
@Aspect
public class UniversityLoginAspect {


    @Before("execution (* getStudents())")
    public void beforeGetStudentsLogingAdvice() {
        System.out.println("beforeGetStudentsLogingAdvice--с");
        System.out.println("----------------------");

    }

    //обычный вариант аннотации afterreturning
    @AfterReturning("execution (* getStudents())")// адвайс выпонится только в случае нормального окончания работы метода бизнес логики
    public void afterGetStudentsLogingAdvice() {
        System.out.println("afterGetStudentsLogingAdvice--");
        System.out.println("----------------------");
    }
    @AfterReturning(pointcut = "execution (* getStudents())",returning = "students")// аннотация позволяет перехватить
    // результат выполнения метода бизнес логики getStudents - записать его ретерн (лист студентов) в параметры метода
    // и сделать с ним все что угодно в теле , после чего результат адвайса вернется в виде результата в метод бизнес
    // логики- тут класс тест2- 15 строка
    public void returnAfterGetStudentsLogingAdvice(List <Aop.Student> students) {
        students.clear();



        System.out.println("afterGetStudentsLogingAdvice--");
        System.out.println("----------------------");
    }
    @AfterThrowing("execution (* exceptGetStudents())")//адвайс отработает только если в процессе выполнения метода
    // выкинется экспешн
    public void afterThwnAdvice(){
        System.out.println("afterThwnAdvice");
        System.out.println("----------------------");
    }
    @AfterThrowing(pointcut = "execution (* exceptGetStudents())",throwing = "e")//адвайс отработает только если в
    // процессе выполнения метода выкинется экспешн ,также как с афтерретернинг можно поймать экспешн и чтото с ним сделать в адвайсе
    public void afterThwnAdvice1(Throwable e){
        System.out.println("afterThwnAdvice");
        System.out.println("----------------------");
        System.out.println("тут есть "+e);
    }
    @After("execution (* exceptGetStudents())")// или еще называют after finally - выполнится в любом случае после
    // окончания метода бизнес логики// , в не зависимости от того выбросится эксепшн или нет
    public void afterAdvice(){
        System.out.println("afterThwnAdvice");
        System.out.println("----------------------");
    }
}
