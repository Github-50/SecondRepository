package myLearning.ProductService.ProductMicroservice.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import myLearning.ProductService.ProductMicroservice.DTO.Product;
import myLearning.ProductService.ProductMicroservice.DTO.ProductTO;
import myLearning.ProductService.ProductMicroservice.Exception.NoRecordsFoundException;
import myLearning.ProductService.ProductMicroservice.Logger.LoggerService;
import myLearning.ProductService.ProductMicroservice.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	@Autowired 
	LoggerService logger;
	
	//Get product method
	public ProductTO getProductById(int id) {
		Optional<Product> product = repository.getProductById(id);
		if(!product.isPresent()) {
			logger.logError("#####No Record found with id: "+ id);
			throw new NoRecordsFoundException("#IN PRODUCTSERVICE - No Record found with id: "+ id+"#.");
		}
		ProductTO productTO = new ProductTO();
		BeanUtils.copyProperties(product.get(), productTO);
		logger.logInfo("Product id found.");
		logger.getLogger().info("#Found#");
		return productTO;
	}
	
	//Get All method
	public List<ProductTO> getAllProducts(){
		List<Product> productList = repository.findAll();
		if(productList == null || productList.isEmpty()) {
			logger.logError("####No Record found");
			throw new NoRecordsFoundException("No Record found!");
		}
		List<ProductTO> productTOlist = new ArrayList<>();
		productList.forEach( product -> {
			ProductTO productTO = new ProductTO();
			BeanUtils.copyProperties(product, productTO);
			productTOlist.add(productTO);
		});
		return productTOlist;
	}
	
	//Post method
	public boolean addProduct(ProductTO productTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productTO, product);
		try {
			repository.save(product);
		}catch(DataAccessException e) {
			logger.logError("Data Access Exception: " + e.getMessage());
		}
		return true;
	}
}
