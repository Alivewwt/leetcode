package project.leetcode;

/*
 * 给定两个有序的数组nums1,nums2，数组长度分别为m,n,然后合并成一个有序的新数组
 */
public class merge {
	public  void merge(int[] nums1,int m,int[] nums2,int n){		
		int i=0,j=0,k=0;
		int num[]=new int[m+n];
		while(i<m&&j<n){
			if(nums1[i]<nums2[j]){
				num[k++]=nums1[i];
				i++;
			}
			else if(nums1[i]>nums2[j]){
				num[k++]=nums2[j];
				j++;
			}
			else{
				num[k++]=nums1[i];
				i++;
				j++;
			}
		}
		while(i<m)
		{
			num[k++]=nums1[i++];
		}
		while(j<n){
			num[k++]=nums2[j++];
		}
		/*
		 * 不用移动元素
		 */
		int aindex=m-1,bindex=n-1;
		int nindex=m+n-1;
		while(aindex>=0&&bindex>=0){
			if(nums1[aindex]>=nums2[bindex]){
				nums1[nindex--]=nums1[aindex];				
				aindex--;
				
			}else {
				nums1[nindex--]=nums2[bindex];
				bindex--;
			}
		}
		while(aindex>=0){
			nums1[nindex]=nums1[aindex];
			nindex--;
			aindex--;
		}
		while(bindex>=0){
			nums1[nindex]=nums2[bindex];
			nindex--;
			bindex--;
		}
	}
}
