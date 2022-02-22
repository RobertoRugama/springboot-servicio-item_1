package com.formacionbdi.springboot.app.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class AppConfig {

	@Bean("clienteRest")
	@LoadBalanced  /*Va_utilizar_Ribben_para_balanceo_de_Carga_haciendo_uso_de_Restemplate*/
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
