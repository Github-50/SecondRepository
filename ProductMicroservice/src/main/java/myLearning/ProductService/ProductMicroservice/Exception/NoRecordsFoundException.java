package myLearning.ProductService.ProductMicroservice.Exception;

public class NoRecordsFoundException extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public NoRecordsFoundException(String message) {
			super(message);
		}
}
