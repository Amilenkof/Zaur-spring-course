package spring_introduction;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

//@Scope ("prototype")
public class Dog implements Pet {
    public Dog() {
        System.out.println("создана собака");
    }

    @Override
    public  void say() {
        System.out.println("Собавка гав гав");
    }
}
