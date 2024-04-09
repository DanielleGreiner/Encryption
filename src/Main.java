import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import javax.crypto.SecretKey;

public class Main {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		System.out.println("Enter something that you want to encrypt");
		String input = keyboard.nextLine();
		
		SecretKey Symmetrickey = KeyGeneration.generateAESKey();
	    byte[] initializationVector = KeyGeneration.createInitializationVector();

	    byte[] cipherText = EncrpytionMethods.do_CIPHEREncryption(input,Symmetrickey,initializationVector);
	    String decryptedText = EncrpytionMethods.do_CIPHERDecryption(cipherText,Symmetrickey,initializationVector);
	   
	    try (FileOutputStream fileOut = new FileOutputStream("encryptdata.txt")) {
	        fileOut.write(cipherText);
	    } catch (Exception e) {
	        System.out.println("Exception occurred while writing to file");
	    }
	    
	    FileInputStream fileIn = new FileInputStream("encryptdata.txt");
	    
        int data;
        try {
        	System.out.print("Your encrypted value is: " );
            while ((data = fileIn.read()) != -1) {
                System.out.print((char) data);  
            }
        } finally {
          fileIn.close();
        }
        System.out.println();
		System.out.println("Your decrypted value is: " + decryptedText);
}
}
