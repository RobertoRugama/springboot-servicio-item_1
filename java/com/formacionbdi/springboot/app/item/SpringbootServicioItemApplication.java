package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableCircuitBreaker // Se comenta porque se va trabajar con Resilience4j
@EnableEurekaClient
//@RibbonClient(name = "servicio-productos") Se comenta servicio ya que se esta usando eurekaClient
@EnableFeignClients  // se deja feignClients para poder conectarnos a las apiRest y se inyectado con Autowired
@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
