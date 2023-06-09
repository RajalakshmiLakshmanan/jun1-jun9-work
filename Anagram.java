package officeWork;

import java.util.HashMap;
import java.util.Map;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Anagram {
	public static boolean isAnagram(String a,String b)
    {
		
     Map<Character,Integer> mapa = new HashMap<Character,Integer>();
     
     Map<Character,Integer> mapb = new HashMap<Character,Integer>();
     
     for(int i=0;i<a.length();i++){
         if(mapa.containsKey(a.charAt(i))) {
        	 Integer value = mapa.get(a.charAt(i));
        	 mapa.put(a.charAt(i), value+1);
        	 
         }else {
        	 
        	 mapa.put(a.charAt(i), 1);
         } 
         
     }
     for (int i = 0; i < b.length(); i++) {
    	 if(mapb.containsKey(b.charAt(i))) {
    		 Integer value = mapb.get(b.charAt(i));
    		 mapb.put(b.charAt(i), value+1);
    	 }else {
    		 
    		 mapb.put(b.charAt(i), 1);
    	 }	 
		
	}
     if(mapa.equals(mapb)) {
    	 return true;
     }
    	 
    return false;
     
     
    }
	public static String reverseWords(String S)
    {
       String[] str = S.split("[^a-zA-z]");
      
       System.out.println(str.length);
       String out= "";
       for(int i=str.length-1;i>=0;i--){
           System.out.println(str[i]);
           out+= " "+str[i];
           
       }
       
       return out;
       
    }
	

	public static void main(String[] args) {
		String S = "i.like.this,program,very,much";
		
		System.out.println("output:"+reverseWords(S));

	}

}
