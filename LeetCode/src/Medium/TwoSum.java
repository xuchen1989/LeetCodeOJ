package Medium;

import java.util.HashMap;

/**
 * 
 * @author xuchen2
 *Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int length = nums.length;
        assert(length>=2);
        int results[] = new int[2];
        // map the nums to the map
        for(int i=0;i<length;i++){
            if(map.containsKey(target-nums[i])){
                int index1= map.get(target-nums[i]);
                results[0] = index1+1;
                results[1] = i+1;
                return results;
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

}
