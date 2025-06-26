package ninzaCRM.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic method related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will capture the current system date in required format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
		return date;
	}
	/**
	 * @author Payal
	 * @param length
	 * @return
	 */
	 public String generateRandomAlphanumeric(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder result = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            result.append(characters.charAt(index));
	        }

	        return result.toString();
	        
	    }
	 /**
	  * This method will return random number
	  * @author Payal
	  * @return
	  */
	  public int getRandomNumber() {
		  Random random = new Random();

	        // Generate a random integer between 0 and 99
	        int randomInt = random.nextInt(100);
			return randomInt;
			
		  
	  }
	}


