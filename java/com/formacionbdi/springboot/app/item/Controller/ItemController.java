package com.formacionbdi.springboot.app.item.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {

	@Autowired
	//@Qualifier("serviceFeign")  //Balanceo_de_carga_usando_ribbon_y_feign
	@Qualifier("serviceRestTemplate")  // Balanceo_de_Carga_usando_ribbon_y_RestTemplate
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.FindAll();
	}
	
	@HystrixCommand(fallbackMethod="metodoAlternativo")
	@GetMapping("/show/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		
		return itemService.findById(id, cantidad);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("camara Sony");
		producto.setPrecio(500.00);
		item.setProducto(producto);		
		return item;
		
	}
	
	
}