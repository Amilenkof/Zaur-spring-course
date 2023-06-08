package Aop;

import Aop.Aspects.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


        University university = context.getBean("university", University.class);
        university.addStudents();
//        List<Student> studentList = university.getStudents();
//        System.out.println(studentList);
        try {

            List<Student> studentList1 = university.exceptGetStudents();
        }catch (Exception e){
            System.out.println("вышел экспешн"+e);
        }

    }

}
