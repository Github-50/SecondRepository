package myLearning.ProductService.ProductMicroservice.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myLearning.ProductService.ProductMicroservice.DTO.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> getProductById(int id);
}
