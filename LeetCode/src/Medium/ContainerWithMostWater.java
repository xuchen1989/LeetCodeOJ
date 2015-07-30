package Medium;

/**
 * 
 * @author xuchen2
 *Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 *n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
 */
public class ContainerWithMostWater {
	
	 public int maxArea(int[] height) {
		 if(height==null)
			 return 0;
		 int length = height.length;
		 if(length==1){
			 return 0;
		 }
		 int leftBar = 0;
		 int rightBar = length-1;
		 int maxArea =0;
		 while(leftBar != rightBar){
			 int currentMax= Math.min(height[leftBar], height[rightBar])*(rightBar-leftBar);
			 if(currentMax > maxArea){
				 maxArea = currentMax;
			 }
			 if(height[leftBar]<height[rightBar]){
				 int lastHeight = height[leftBar];
				 while(leftBar<rightBar && height[leftBar]<=lastHeight){
					 leftBar++;
				 }
			 }else{
				 int lastHeight = height[rightBar];
				 while(rightBar>leftBar && height[rightBar]<=lastHeight){
					 rightBar--;
				 }
			 }
		 }
		 return maxArea;
	 }
	 
	 //internaet
	 public int maxArea2(int[] height) {
	        int ans = 0;
	        int tmp = 0;
	         
	        int l = 0;
	        int r = height.length - 1;
	        while (l < r)
	        {
	            int min = Math.min(height[l], height[r]);
	            tmp = min * (r - l);
	            if (tmp > ans) ans = tmp;
	            if ( height[l] < height[r])
	            {
	                int last = height[l];
	                while (l < r && height[l] <= last)
	                {
	                    l++;
	                }
	            }
	            else
	            {
	                int last = height[r];
	                while (l < r && height[r] <= last)
	                {
	                    r--;
	                }
	            }
	        }
	        return ans;
	    }
}
