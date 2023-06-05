package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {

        // вместе в склассом Conf работает
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
//        Cat cat= context.getBean("catBean", Cat.class);
        Person person=context.getBean("person", Person.class);
//        person.callYourPet();
        System.out.println(person.toString());
        context.close();
    }
}
