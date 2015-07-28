package Easy;
/**
 * 
 * @author xuchen2
 *Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {
	//init code
	public int reverse(int x) {
        boolean negative = false;
        String str = String.valueOf(x);
         if(x<0){
            negative = true;
            str = str.substring(1);
        }
        char[] strArray = str.toCharArray();
        int length = strArray.length;
        
        for(int i=0;i<length/2;i++){
        	char temp = strArray[i];
        	strArray[i] = strArray[length-1-i];
        	strArray[length-1-i] = temp;
        }
        str = String.valueOf(strArray);
        int reverseX = 0;
        try{
             reverseX = Integer.parseInt(str);
        }catch(Exception e){
            return reverseX;
        }
        if(negative){
            return -reverseX;
        }
        return reverseX;
    }
	//solution 
	//To check for overflow/underflow, we could check if ret > 214748364 or ret < ¨C214748364 before multiplying by 10.
	//On the other hand, we do not need to check if ret == 214748364, why?
	public int reverse2(int x) {
		   if(x==Integer.MIN_VALUE)
		       return 0;
		   int num = Math.abs(x);
		   int res = 0;
		   while(num!=0){
		       if(res > (Integer.MAX_VALUE-num%10)/10){
		           return 0;
		       }
		       res = res*10+num%10;
		       num /= 10;
		   }
		   return x>0?res:-res;
	    }
}
