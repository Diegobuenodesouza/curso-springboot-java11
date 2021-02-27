package com.example.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.Category;
import com.example.curso.entities.Order;
import com.example.curso.entities.Product;
import com.example.curso.entities.User;
import com.example.curso.entities.enums.OrderStatus;
import com.example.curso.repositories.CategoryRepository;
import com.example.curso.repositories.OrderRepository;
import com.example.curso.repositories.ProductRepository;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		Category c1 = new Category(null, "Books");
		Category c2 = new Category(null, "Eletronics");
		Category c3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "999998888" , "123123");
		User u2 = new User(null, "Alex", "alex@gmail.com", "999998888" , "32232");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
					
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,  u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED , u1);

		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5)) ;
				
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
		
		
		
	}
}
