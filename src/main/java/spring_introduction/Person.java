package spring_introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class Person {

    private  Pet pet;
    @Value("${person.surname}")
//    @Value("Миленьков")    @Value("Миленьков")
    private String surname;
    @Value("${person.age}")
//    @Value("32")
    private int age;


//   @Autowired
//    public Person(Pet pet) {
//       System.out.println("человек создан");
//        this.pet = pet;
//    }

    public Person() {
        System.out.println("создан человек");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Установлена фамилия");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("установлен возраст");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pet=" + pet +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public  void callYourPet() {
        System.out.println("Эй ты где");
        this.pet.say();
    }

@Autowired
@Qualifier("dog")

    public void setPet(Pet pet) {
        System.out.println("Class person set pet");
        this.pet = pet;
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("инит метод");
//    }@PreDestroy
//    public void destroy() {
//        System.out.println("дестрой метод");
//    }
}
