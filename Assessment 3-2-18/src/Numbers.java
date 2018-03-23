import java.awt.List;
import java.util.ArrayList;

public class Numbers
{

    /** 	@param num is a positive non-decimal value
     *  		Precondition : num >= 0
     *  	@return true if the sum of digit divisors of num is odd 
@return false if the sum of the digit divisors of num is even
     */
	
	public static void main(String args[]){
		System.out.println(isGoofy(1234));
		System.out.println(getSomeGoofyNumbers(5));
	}
  public static boolean isGoofy(int num)
  {  
	int sum=0;
	int n = num;
     for (int i = 1; n>0; i=i*10){
    	 int count=0;
    
    	 while(n%(i*10)!=0){
    		 count++;
    		 n  = n-i;
    	 }
    	 if (num%count==0){
    		 sum = sum + count;
    	 }
    	 
     }
     if (sum%2 == 1){
    	 return true;
     }
     return false;
  }

	
    /* @param count is a positive non-decimal value
     *  		Precondition : count > 0
     *   @return an array containing count Goofy numbers
     */   
 public static ArrayList getSomeGoofyNumbers(int count)
 {
     ArrayList goofs = new ArrayList();
     int n=0;
     
     for (int i = 1; n<count; i++){
    	 if(isGoofy(i)){
    		 goofs.add(i);
    		 n++;
    	 }
     }
     return goofs;
}	
   
  // There may be variables / fields, constructors, and methods that are not shown.

}
