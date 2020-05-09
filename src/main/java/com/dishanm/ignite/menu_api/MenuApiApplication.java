package com.dishanm.ignite.menu_api;

import dishanm.ignite.beans.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EntityScan(basePackages = {"dishanm.ignite.beans","com.dishanm.ignite.menu_api.model"})
@Import(Item.class)
public class MenuApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApiApplication.class, args);
	}

}
