package Aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("Aop")//показываем в каком пакете искать бины
@EnableAspectJAutoProxy// позволять использовать спринг АОР PROXY

public class MyConfig {
}
