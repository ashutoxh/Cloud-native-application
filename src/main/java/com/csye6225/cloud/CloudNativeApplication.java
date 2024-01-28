package com.csye6225.cloud;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class CloudNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNativeApplication.class, args);
    }

}
