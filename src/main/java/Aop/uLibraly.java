package Aop;

import org.springframework.stereotype.Component;

@Component
public class uLibraly extends AbstractLibraly{
@Override
    public void getBook() {
        System.out.println("мы берем книгу uLibraly ");
    }

}
