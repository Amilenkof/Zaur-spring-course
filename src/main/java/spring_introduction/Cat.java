package spring_introduction;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("catBean")

//@Component
public class Cat implements Pet{

    @Override
    public void say() {
        System.out.println("Мяу мяу");

    }

    public Cat() {
        System.out.println("кот создан");
    }
}
