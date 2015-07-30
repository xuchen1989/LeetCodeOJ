package Hard;

/**
 * 
 * @author xuchen2
 *Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "a*") ¡ú true
isMatch("aa", ".*") ¡ú true
isMatch("ab", ".*") ¡ú true
isMatch("aab", "c*a*b") ¡ú true
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if(p==null)
			return s==null;
		if(p.length()==0){
			return s.length()==0;
		}
		if(p.length()==1){
			return s.length()==1 && (p.charAt(0)=='.' || p.charAt(0) == s.charAt(0));
		}
		if(p.charAt(1)!='*'){
			return s.length()>0 &&
					(p.charAt(0)=='.' || p.charAt(0) == s.charAt(0)) &&
					isMatch(s.substring(1), p.substring(1));
		}else{
			if(isMatch(s, p.substring(2))){
				return true;
			}
			return s.length()>0 &&
					(p.charAt(0)=='.' || p.charAt(0) == s.charAt(0)) &&
					isMatch(s.substring(1), p);
		}
        
    }
}
