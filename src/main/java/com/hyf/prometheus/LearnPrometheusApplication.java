package com.hyf.prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class LearnPrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnPrometheusApplication.class, args);
    }

}
