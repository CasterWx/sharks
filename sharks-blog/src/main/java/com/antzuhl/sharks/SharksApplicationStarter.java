package com.antzuhl.sharks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author AntzUhl
 * @date 2021/7/6 11:06 上午
 * @description SharksApplicationStarter
 **/
@Slf4j
@SpringBootApplication
public class SharksApplicationStarter implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SharksApplicationStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.warn(">>> SharksApplicationStarter starter success");
    }
}
