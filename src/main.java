import java.util.*;

public class main {
	
	public static void main(String[] args) {
		hash hash = new hash();
		salt salt = new salt();
		verify verify = new verify();
		
		String salty = salt.generateSalt(512).get();
		System.out.println(salty);
		
		String password = "This is my password!";
		System.out.println(password);

		String key = hash.hashPassword(password, salty).get();
		
		System.out.println(verify.verifyPassword("This is my password!", key, salty));
		System.out.println(verify.verifyPassword("random ass password", key, salty));

	}
}