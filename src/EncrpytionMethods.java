import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncrpytionMethods {

	
	
	public static byte[] do_CIPHEREncryption(String input,SecretKey secretKey,byte[] initializationVector)throws Exception{
			Cipher cipher= Cipher.getInstance(Secret.CIPHER_ALGORITHM);

			IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
			cipher.init(Cipher.ENCRYPT_MODE,secretKey,ivParameterSpec);
			return cipher.doFinal(input.getBytes());
		}
		public static String do_CIPHERDecryption(byte[] cipherText,SecretKey secretKey,byte[] initializationVector)throws Exception{
			Cipher cipher = Cipher.getInstance(Secret.CIPHER_ALGORITHM);

			IvParameterSpec ivParameterSpec= new IvParameterSpec(initializationVector);
			cipher.init(Cipher.DECRYPT_MODE,secretKey,ivParameterSpec);
			byte[] result = cipher.doFinal(cipherText);
			return new String(result);
		}
}
