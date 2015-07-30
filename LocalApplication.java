package com.springbatch;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ksy on 2015/7/24.
 */
@SpringBootApplication
public class LocalApplication {

    Logger logger = Logger.getLogger(LocalApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LocalApplication.class, args);
    }

}
