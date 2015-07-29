package Medium;
/**
 * 
 * @author xuchen2
 *Given a string S, find the longest palindromic substring in S. 
 *You may assume that the maximum length of S is 1000, 
 *and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s==null || "".equals(s.trim()) || s.length()==1)
			return s;
		int length = s.length();
		int max = 0;
		String maxStirng = "";
		for(int i=0;i<length*2-1;i++){
			int left = i/2;
			int right =i/2;
			if(i%2==1){
				right++;
			}
			String palindromicString = getPalin(left,right,s);
			if(palindromicString.length()>max){
				max = palindromicString.length();
				maxStirng = palindromicString;
			}
		}
		return maxStirng;
		
    }

	private String getPalin(int left, int right, String s) {
		while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
			left--;
			right ++;
		}
		return s.substring(left+1, right);
	}
}
