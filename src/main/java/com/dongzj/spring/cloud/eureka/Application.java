package com.dongzj.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.net.ServerSocket;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Application {

    public static void main(String[] args) {
        System.setProperty("server.port", getRandomIdlePort() + "");
        SpringApplication.run(Application.class, args);
    }

    public static int getRandomIdlePort() {
        int i = 0;

        while (i < 3) {
            try {
                ServerSocket serverSocket = new ServerSocket(0);
                return serverSocket.getLocalPort();
            } catch (Exception var2) {
                ++i;
            }
        }

        return 8111;
    }
}
