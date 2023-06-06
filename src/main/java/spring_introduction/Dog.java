package spring_introduction;

public class Dog implements Pet {
    private String name;
    public Dog() {

        System.out.println("создана собака");
    }
    public  void init() {
        System.out.println("класс дог инит метод");
    }
    public  void destroy() {
        System.out.println("класс дог дестрой метод");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public  void say() {
        System.out.println("Собавка гав гав");
    }
}
