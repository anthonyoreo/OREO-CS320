import java.util.Optional;

public class verify {
	
	
	public static boolean verifyPassword(String password, String key, String salt) {
		hash hash = new hash();

	    Optional<String> optEncrypted = hash.hashPassword(password, salt);
	    if (!optEncrypted.isPresent()) return false;
	    return optEncrypted.get().equals(key);
	}
}