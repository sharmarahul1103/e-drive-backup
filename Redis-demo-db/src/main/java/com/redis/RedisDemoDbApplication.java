package com.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Product;
import com.redis.repository.ProductDao;

@SpringBootApplication
@RestController
public class RedisDemoDbApplication {

	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/save")
	public Product save(@RequestBody Product product)
	{
		return productDao.save(product);
		
	}
	
	@GetMapping("/findall")
	public List<Object> getAllProduct()
	{
		return productDao.getAllProducts();
	}
	
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id)
	{
		return productDao.findById(id);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return productDao.deleteProduct(id);
	}
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(RedisDemoDbApplication.class, args);
	}
	
	
	

}
