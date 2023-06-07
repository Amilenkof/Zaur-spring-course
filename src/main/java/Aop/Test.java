package Aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(MyConfig.class);
        uLibraly libraly = context.getBean("uLibraly", uLibraly.class);
//        libraly.getBook();
        SLibraly sLibraly = context.getBean("SLibraly", SLibraly.class);
//        sLibraly.getBook();
//        sLibraly.returnBook();
//        sLibraly.getMagazine();
//        sLibraly.anithingWithBook(" ок ");


        sLibraly.joinPointTest("ОК",2312);





        context.close();
    }
}
