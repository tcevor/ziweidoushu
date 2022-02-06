package org.doushu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类
 *
 * @author by GBJ
 * @date on 2017/10/18.
 * @Description:
 */

@SpringBootApplication
public class AppliactionController {
    public static void main(String[] args) {
        //System.setProperty("spring.devtools.restart.enabled", "false"); //重启功能完全失效
        SpringApplication.run(AppliactionController.class);
    }
}


