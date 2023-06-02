package spring_introduction;

public class Dog implements Pet {
    public Dog() {
        System.out.println("создана собака");
    }

    @Override
    public  void say() {
        System.out.println("Собавка гав гав");
    }
}
