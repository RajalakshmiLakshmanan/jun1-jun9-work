package officeWork;
//Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
//
//Example 1:
//
//Input:
//a = amazon
//b = azonam
//Output: 1
//Explanation: amazon can be rotated anti
//clockwise by two places, which will make
//it as azonam.

public class RotateString {
	public static boolean isRotated(String str1, String str2)
  {
      int l1 = str1.length();
      int l2 = str2.length();
      if(l1==l2&&l1>=2&&l2>=2) {
    	  String substr1 = str1.substring(0, 2);
    	  String endstr = str1.substring(2,l1);
    	  String clockstr = endstr + substr1;
    	  
    	  String subend = str1.substring(l1-2,l1);
	      String front = str1.substring(0,l1-2);
	      String anticlock = subend + front;
	      if(str2.equals(anticlock)||str2.equals(clockstr)) {
	    	  return true;
	    	  
	      }
    	  
    	  
      }
		
		return false;
		
    }

	public static void main(String[] args) {
		String str1= "amazon";
		String str2 = "azonam";
		System.out.println("output:"+isRotated(str1,str2));
 	   
	}

}
