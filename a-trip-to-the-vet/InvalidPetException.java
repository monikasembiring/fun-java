package objectoriented;

public class InvalidPetException extends RuntimeException{
	public InvalidPetException() {
		System.out.println("Your pet is invalid!");
	}
	
	public InvalidPetException(String s) {
		System.out.println(s);
	}
}
