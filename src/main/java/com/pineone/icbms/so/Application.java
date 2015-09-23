package com.pineone.icbms.so;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by existmaster on 2015. 6. 18..
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        SpringApplication app= new SpringApplication(Application.class);
        app.run(args);

    }
}
