package Aop.Aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCut {
    @Pointcut("execution(* Aop.SLibraly.return*())")//тут прописывает какойто поинткат который будет использовать в адвайсе класса POINTCUTFROMMYPOINTCUT
    public void allReturnMethodsSlibraly() {
    }
}
