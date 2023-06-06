package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Singletone {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");// этот класс создает контекст - в  параметры передаем название файла с контектом , можно указать несколько файлов

        Dog my = context.getBean("myDog", Dog.class);
        my.setName("белка");
        Dog yourDog = context.getBean("myDog", Dog.class);
        yourDog.setName("стрелка");
        System.out.println(my.getName());
        System.out.println(yourDog.getName());
        System.out.println(my == yourDog);//при создании 2 обьектов из 1 бина получается что обьект 1, обе ссылки ссылаются на этот обьект
// в обоих случаях обьекты ссылаются на бин с паттерном сиглтон, значит создается всего один обьект и при смене имени собаки меняется имя в полях обьекта, сначало на белка потом на стрелка
        context.close();
    }
}
