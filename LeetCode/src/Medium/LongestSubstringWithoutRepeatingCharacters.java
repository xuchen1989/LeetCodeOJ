package Medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        int max =0;
        HashSet<Character> hashSet = new HashSet<Character>();
        if(s==null || "".equals(s.trim())){
            return max;
        }
        int subMax = 0;
        int leftBound = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hashSet.contains(c)){
                while(s.charAt(leftBound)!=c){
                    hashSet.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            }else{
                hashSet.add(c);
                subMax = hashSet.size();
                if(subMax>max)
                   max = subMax;
            }
        }
       return max;
   }
}
