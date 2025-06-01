package myLearning.ProductService.ProductMicroservice.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductTO {
	private int id;
	
	@NotEmpty(message = "Invalid type: type is Empty!")
	@NotBlank(message = "Invalid type: type is Blank!")
	@Size(min = 5, max = 30, message = "Invalid type: Less than 5 characters or more than 30 characters long!")
	private String type;
	
	@NotEmpty(message = "Invalid name: Name is Empty!")
	@NotBlank(message = "Invalid name: Name is Blank!")
	@Size(min = 3, max = 30, message = "Invalid name: Less than 3 characters or more than 30 characters long!")
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotEmpty(message = "Invalid quantity: Quantity is Empty!")
	@NotBlank(message = "Invalid quantity: Quantity is Blank!")
	private int quantity;

	public ProductTO() {}
	
	public ProductTO(int id, String type, String name, String description,
			int quantity) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductTO [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ "]";
	}
}
