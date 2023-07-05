package com.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.entity.Product;

@Repository
public class ProductDao {
	
	private static final String HASH_KEY = "Product";
	@Autowired
	private RedisTemplate<String, Object> template;
	
	public Product save(Product product)
	{
		template.opsForHash().put("Product", product.getId(), product);
	    return product;
	
	}
	
	public List<Object> getAllProducts()
	{
	 return 	template.opsForHash().values(HASH_KEY);
	}
	
	
	public Product findById(int id)
	{
		return (Product) template.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteProduct(int id)
	{
		template.opsForHash().delete(HASH_KEY, id);
		return "item deleted";
	}
	

}
