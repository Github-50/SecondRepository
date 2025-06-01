package myLearning.ProductService.ProductMicroservice.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import myLearning.ProductService.ProductMicroservice.DTO.ProductTO;
import myLearning.ProductService.ProductMicroservice.Exception.NoRecordsFoundException;
import myLearning.ProductService.ProductMicroservice.Logger.LoggerService;
import myLearning.ProductService.ProductMicroservice.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	@Autowired
	LoggerService logger;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		try {
			return new ResponseEntity<> (service.getProductById(id), HttpStatus.OK);
		}catch(NoRecordsFoundException e) {
			throw new NoRecordsFoundException(e.getMessage()+ " #INSIDE PRODUCTCONTROLLER#");
		}
	}
	/*
	 * http://localhost:8080/products/add
	 *{
		  "type" : "HardWare",
		  "name" : "Mouse",
		  "description" : "An input device to click and do.",
		  "quantity" : 4
	  }*/
	
	@PostMapping("/add")
	public ResponseEntity<ProductTO> addProduct(@RequestBody ProductTO newProduct){
		try{
			if(service.addProduct(newProduct))
				return ResponseEntity.created(null).build();
		}catch(NoRecordsFoundException e) {
			throw new NoRecordsFoundException("Input Product "+ newProduct + " can not be created!");
		}
		return null;
	}
	
	
	@GetMapping("/allProducts")
	public ResponseEntity<?> getAllProducts(){
		try {
			return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
		}catch(NoRecordsFoundException e) {
			throw new NoRecordsFoundException("Product repository is empty!"+ e.getMessage());
		}
	}
}
