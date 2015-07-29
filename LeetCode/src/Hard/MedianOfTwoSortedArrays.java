package Hard;

/**
 * 
 * @author xuchen2
 *There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 *Find the median of the two sorted arrays. 
 *The overall run time complexity should be O(log (m+n))
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null ||nums2==null)
        	return 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        if((length1+length2)%2!=0){
        	return findKth(nums1, 0, length1-1, nums2, 0, length2-1, (length1+length2)/2+1);
        }else{
        	double x = findKth(nums1, 0, length1-1, nums2, 0, length2-1, (length1+length2)/2);
        	double y = findKth(nums1, 0, length1-1, nums2, 0, length2-1, (length1+length2)/2+1);
        	return (x+y)/2.0;
        	
        }
    }
	private static int findKth(int a[],int astart,int aend, int b[],int bstart,int bend,int k){
		int m = aend-astart+1;
		int n = bend-bstart+1;
		if(m>n){
			return findKth(b,bstart,bend,a,astart,aend,k);
		}
		if(m==0){
			return b[k-1];
		}
		if(k==1){
			return Math.min(a[astart], b[bstart]);
		}
		int partA = Math.min(k/2, m);
		int partB = k-partA;
		if(a[astart+partA-1]<b[bstart+partB-1]){
			return findKth(a,astart+partA,aend,b,bstart,bend,k-partA);
		}else if(a[astart+partA-1]>b[bstart+partB-1]){
			return findKth(a,astart,aend,b,bstart+partB,bend,k-partB);
		}else{
			return a[astart+partA-1];
		}
		
	}
	
	//¾ÅÕÂ
	public double findMedianSortedArrays2(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0 ;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k){		
		if(A_start >= A.length) 
			return B[B_start + k - 1];
		if(B_start >= B.length)
			return A[A_start + k - 1];

		if (k == 1)
			return Math.min(A[A_start], B[B_start]);
		
		int A_key = A_start + k / 2 - 1 < A.length
		            ? A[A_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length
		            ? B[B_start + k / 2 - 1]
		            : Integer.MAX_VALUE; 
		
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
}
