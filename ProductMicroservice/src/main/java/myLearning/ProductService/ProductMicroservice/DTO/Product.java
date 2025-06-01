package myLearning.ProductService.ProductMicroservice.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_PRD_PRODUCT", uniqueConstraints = @UniqueConstraint(columnNames	= {"id"}))
public class Product {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String type;
	private String name;
	private String description;
	private int quantity;
	
	public Product() {}

	public Product(int id, String type, String name, String description, int quantity) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "Product [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description
				+ ", quantity=" + quantity + "]";
	}	
}
