package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prototype {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext3.xml");
        Dog dog1 = context.getBean("myDog",Dog.class);
        Dog dog2 = context.getBean("myDog",Dog.class);
        dog1.setName("Белка");
        dog2.setName("Стрелка");
        System.out.println(dog1 == dog2);
        System.out.println(dog1.getName());
        System.out.println(dog2.getName());

// в скоупе prototype создаются разные обьекты дог с разными ссылками


        context.close();
    }
}
