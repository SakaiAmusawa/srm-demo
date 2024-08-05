package com.srm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoYiApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println(
                "       ccee88oo                            ccee88oo\n" +
                        "   C8O8O8Q8PoOb o8oo                 C8O8O8Q8PoOb o8oo\n" +
                        "dOB69QO8PdUOpugoO9bD           dOB69QO8PdUOpugoO9bD\n" +
                        "CgggbU8OU qOp qOdoUOdcb    CgggbU8OU qOp qOdoUOdcb\n" +
                        "      6OuU  /p u gcoUodpP        6OuU  /p u gcoUodpP\n" +
                        "        \\\\\\//  /douUP                \\\\\\//  /douUP\n" +
                        "          \\\\\\////                      \\\\\\////\n" +
                        "          |||/\\                        |||/\\\n" +
                        "          |||\\/                        |||\\/\n" +
                        "          |||||                        |||||\n" +
                        "    .....//||||\\....              .....//||||\\....\n"
        );
    }
}
