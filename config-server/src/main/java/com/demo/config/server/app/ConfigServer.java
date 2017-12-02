package com.demo.config.server.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
@RestController
public class ConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
	}
}
