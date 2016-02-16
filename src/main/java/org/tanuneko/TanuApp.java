package org.tanuneko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by neko32 on 2016/02/16.
 */

@ComponentScan("org.tanuneko")
@SpringBootApplication
public class TanuApp {

    public TanuApp() {}

    public void start(String args[]) {
        System.out.println("Starting app..");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TanuConfiguration.class);
        SpringApplication.run(TanuApp.class, args);
    }

    public static void main(String args[]) {
        TanuApp t = new TanuApp();
        t.start(args);
    }
}
