package configWithoutAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Conf.class);


//        Person person = context.getBean("personBean", Person.class);

    }
}
