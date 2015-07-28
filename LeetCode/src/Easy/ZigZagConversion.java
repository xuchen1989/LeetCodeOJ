package Easy;

/**
 * 
 * @author xuchen2
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 *(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
	//init Code
	 public static String convert(String s, int numRows) {
		 char[] strArray = s.toCharArray();
		 int length = strArray.length;
		 if(numRows==1 || length<=numRows)
			 return s;
        int group = numRows*2-2;
        
        char[] zigZagStr = new char[length];
        int index = 0;
        int jumper =0;
        while(jumper<length){
        	zigZagStr[index] = strArray[jumper];
        	jumper += group;
        	index++;
        }
        
        jumper=1;
        int i=jumper;
        while(i<numRows-1){
        	while(i<length){
        		zigZagStr[index] = strArray[i];
            	i += numRows-1;
            	index++;
        	}
        	jumper ++;
        	i = jumper;
        }
        jumper = numRows-1;
        while(jumper<length){
        	zigZagStr[index] = strArray[jumper];
        	jumper += group;
        	index++;
        }
        return String.valueOf(zigZagStr);
	 }
	 public static void main(String[] args) {
		System.out.println(convert("abcdefghijklmnopqrstuvwxyz", 6));
	}
}
