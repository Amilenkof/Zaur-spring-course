package spring_introduction;

public class Person {
    private  Pet pet;
    private String surname;
    private int age;

    public Person() {
        System.out.println("создан персон");
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

    public  void callYourPet() {
        System.out.println("Эй ты где");
        this.pet.say();
    }

    public void setPet(Pet pet) {
        System.out.println("сет пет в персону");
        this.pet = pet;
    }
}
