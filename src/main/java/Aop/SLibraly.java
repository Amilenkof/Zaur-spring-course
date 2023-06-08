package Aop;

import org.springframework.stereotype.Component;

@Component
public class SLibraly extends AbstractLibraly{

    @Override
    public void getBook() {
        System.out.println("мы берем книгу SLibraly ");
    }

    public void returnBook() {
        System.out.println("возвращаем книгу SLibraly");
    }
    public void returnMagazin() {
        System.out.println("возвращаем журнал SLibraly");
    }
    public  void getMagazine(){
        System.out.println("берем журнал SLibraly  ");
    }
    public void anithingWithBook(String s) {
        System.out.println("какойто метод с книгой " + s);
    }
    public void addBook() {
        System.out.println("добавляем книгу в Slibraly" );
    }
    public void addMagazin() {
        System.out.println("добавляем журнал в Slibraly" );
    }
    public String returnAround () {
        System.out.println("проверка аннотации Round");
        return "Метод returnAround";
    }

    public void joinPointTest(String s,int a ) {
        System.out.println("Параметр 1= " +s +"Параметр 2 = "+ a);
    }
}
