
import java.util.List;

public class StringBasics {
	
	public static void main(String[] args) {
		
		// instanciate in two ways: 
		//using string literals 
		
		String str= "Hello";
		System.out.println(str=="Hello");
		
		//using new Keyword
		
		String string = new String("Hello");
		System.out.println(string=="Hello");
		
		// length of string
		int length = string.length();
		System.out.println(length);
		
		//iteration Using charAt()
		for(int i=0;i<length;i++) {
			System.out.println(string.charAt(i));
		}
		
		//substring function 
		//using two index
		System.out.println(string.substring(0, 3));
		//using only first index 
		System.out.println(string.substring(2));
		
		//equals and equalsIgnoreCase()
		System.out.println(string.equals(str));
		System.out.println(string.equalsIgnoreCase(str));
		
		//to char array
		System.out.println(string.toCharArray());
		
		//split logic
		String trySplit="hel:lo";
		String[] splitString = trySplit.split(":");
		for(String strr:splitString) {
			System.out.println(strr);
		}
		
		//trim() it trims  spaces 
		
		
		
		
		
	}

}
