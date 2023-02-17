package br.pucpr.cityeventspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CityEventSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityEventSpringApplication.class, args);
    }

}
