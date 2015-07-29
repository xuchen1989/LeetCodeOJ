package Easy;

/**
 * 
 * @author xuchen2
 *Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. 
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 You are responsible to gather all the input requirements up front.
 Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
  and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters,
  no conversion is performed.

If no valid conversion could be performed, 
a zero value is returned. 
If the correct value is out of the range of representable values, 
INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("   +0 123"));
	}
	public static int myAtoi(String str) {
        if(str==null || "".equals(str.trim()))
        	return 0;
        boolean negative = false;
        str = str.trim();
        if(str.startsWith("-") || str.startsWith("+")){
        	if(str.startsWith("-"))
        		negative=true;
        	str = str.substring(1);
        }
        int result =0;
        for(int i=0;i<str.length();i++){
        	if(!Character.isDigit(str.charAt(i))){
        		return negative?-result:result;
        	}
        	if("0".equals(str.charAt(i)))
        		continue;
        	int currentNum = (int)str.charAt(i)-48;
        	if((Integer.MAX_VALUE-currentNum)/10 < result){
        		return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        	}
        	result = 10*result+currentNum;
        }
        return negative?-result:result;
    }

}
