package com.upgrad.eshopApp;

//import com.upgrad.eshopApp.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
//public class EShopBackendApplication implements CommandLineRunner {
//	@Autowired
//	InitService initService;
public class EShopBackendApplication {
	public static void main(String[] args) {

		SpringApplication.run(EShopBackendApplication.class, args);

	}
//	@Override
//	public void run(String... arg0){
//		initService.insertData();
//
//	}

}
