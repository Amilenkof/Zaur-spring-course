package configWithoutAnnotation;

public class Person {
    String name;
    Pet pet;

    public Person(Pet pet) {
        System.out.println("Man is HERE");
        this.pet = pet;
    }
}
