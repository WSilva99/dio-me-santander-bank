package me.dio.santander.infra;

import me.dio.santander.infra._config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(ServerConfig.class, args);
    }

}
