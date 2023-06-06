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
    public  void getMagazine(){
        System.out.println("берем журнал SLibraly  ");
    }
}
