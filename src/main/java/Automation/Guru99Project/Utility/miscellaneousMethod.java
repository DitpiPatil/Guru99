package Automation.Guru99Project.Utility;
import java.util.Random;
public class miscellaneousMethod {

	public int getrandomnumber() {
		 double getRandom = Math.random() * 100; 
         int getRoundoff = (int) Math.round(getRandom);
		return getRoundoff;
	}
	public String getRandomString() {
		   int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		    
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();

		   // System.out.println(generatedString);
			return generatedString;
		}
}
