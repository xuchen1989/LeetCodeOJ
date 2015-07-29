package Easy;

/**
 * 
 * @author xuchen2
 *Determine whether an integer is a palindrome. Do this without extra space
 */
public class PalindromNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome2(1201));
	}
	public static boolean isPalindrome(int x) {
		if(x<0)
			return false;
        if(x<10)
        	return true;
        int digit = 0;
        int num = x;
        while (num>0){
        	digit++;
        	num /= 10;
        }
        while(x%10 == (int)(x/Math.pow(10, digit-1))){
        	x %= Math.pow(10, digit-1);
        	x /= 10;
        	digit -=2;
        	if(digit<=0){
        		return true;
        	}
        }
        return false;
    }
	
	//refactor
	public static boolean isPalindrome2(int x) {
		if(x<0)
			return false;
        if(x<10)
        	return true;
        int digit = 1;
        while (x/digit>=10){
        	digit *= 10;
        }
        while(x%10 == x/digit){
        	x %= digit;
        	x /= 10;
        	digit /=100;
        	if(digit<=0){
        		return true;
        	}
        }
        return false;
    }

}
