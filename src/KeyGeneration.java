import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



public class KeyGeneration {
	
		

		public static SecretKey generateKey()throws Exception{
			SecureRandom securerandom = new SecureRandom();
			KeyGenerator keygenerator = KeyGenerator.getInstance(Secret.CIPHER);

			keygenerator.init(256, securerandom);
			SecretKey key= keygenerator.generateKey();
			return key;}

		public static byte[] createInitializationVector(){
			byte[] initializationVector = new byte[16];
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.nextBytes(initializationVector);
			return initializationVector;
		}

	}

	


	
