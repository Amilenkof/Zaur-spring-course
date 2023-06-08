package Aop.Aspects;

import Aop.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class University {
    private List<Student> students = new ArrayList<>();


    public void addStudents() {
        Student st1 = new Student("Саща", 2, 3.5);
        Student st2 = new Student("Маша", 4, 6.5);
        Student st3 = new Student("Елена", 6, 2.5);
        Student st4 = new Student("Катя", 1, 6.5);

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
    }
    public List <Student> getStudents () {

        System.out.println("Информация по методу getStudents");
        System.out.println(students);
        return students;
    }
    public List <Student> exceptGetStudents () {
        System.out.println("Начало работы getStudents");
        System.out.println(students.get(6));
        System.out.println("Информация по методу getStudents");
        System.out.println(students);
        return students;
    }

}
