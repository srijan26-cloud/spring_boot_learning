package com.jpatut.jpatutorial;

import com.jpatut.jpatutorial.Entities.ProductEntity;
import com.jpatut.jpatutorial.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatutorialApplicationTests {

	@Autowired
	ProductRepository product_Repository;

    @Test
	void contextLoads() {
	}

	@Test
	void addRow() {

		ProductEntity product_Entity = ProductEntity
				.builder()
				.productName("PEPSI coke")
				.sku("PEPSI")
				.productPrice(BigDecimal.valueOf(243))
				.productQuantity(2)
				.build();

		ProductEntity saved_Entity = product_Repository.save(product_Entity);
		System.out.println(saved_Entity);
	}

	@Test
	public void findByName(){
		ProductEntity productEntity = product_Repository.findByProductName("PEPSI coke");
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom1(){
		List<ProductEntity> productEntity = product_Repository.findByProductNameStartingWith("PEPSI");
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom2(){
		ProductEntity productEntity = product_Repository.findFirstByProductNameStartingWith("PEPSI");
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom3(){
		ProductEntity productEntity = product_Repository.findDistinctByProductNameAndSku("PEPSI" , "PEPSI CO");
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom4(){
		List<ProductEntity> productEntity = product_Repository.findByCreatedAtAfter(LocalDateTime.of(2024,9,7,0,0,0));
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom5(){
		List<ProductEntity> productEntity = product_Repository.findByProductQuantityLessThanOrProductPriceGreaterThan(3,BigDecimal.valueOf(453));
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom6(){
		List<ProductEntity> productEntity = product_Repository.findByProductNameLike("%PEPSI%");
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom7(){
		List<ProductEntity> productEntity = product_Repository.findByProductNameContaining("PEPSI");
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom8(){
		List<ProductEntity> productEntity = product_Repository.findByProductNameContainingIgnoreCase("PEPSI");
		System.out.println(productEntity);
	}

	@Test
	public void findByCustom9(){
		Optional<ProductEntity> productEntity = product_Repository.findByProductNameAndProductPrice("PEPSI coke", BigDecimal.valueOf(243) );
		productEntity.ifPresent(System.out::println);
	}

	@Test
	public void findByCustom10(){
		Optional<ProductEntity> productEntity = product_Repository.findByProductNameAndProductQuantity("PEPSI coke", 2 );
		productEntity.ifPresent(System.out::println);
	}
}
