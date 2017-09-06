/*
*	Example 1:
	Input: [1,2,3,4,5], k=4, x=3
	Output: [1,2,3,4]
	Example 2:
	Input: [1,2,3,4,5], k=4, x=-1
	Output: [1,2,3,4]
	题目：https://leetcode.com/problems/find-k-closest-elements/description/
*/
class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        //二分查找吗，如果在list中没有找到元素，则返回插入位置+1
        //1,2,4,5 x=3 插入位置idx=2,所有返回-2-1=-3
         List<Integer> res=new ArrayList<Integer>();
		 if(x<=arr.get(0)){
			 return arr.subList(0, k);
		 }else if(x>=arr.get(arr.size()-1)){
			 return arr.subList(arr.size()-k, arr.size());
		 }else{
			 int index=Collections.binarySearch(arr, x);
		        //使用二分查找
		     	if(index<0)
                    index=-index-1;
		        	int low=Math.max(0,index-k-1),high=Math.min(arr.size()-1, index+k-1);
		        	while(high-low>k-1){
		        		if(low<0||(x-arr.get(low))<=(arr.get(high)-x))
		        			high--;
		        		else if(high>arr.size()-1||(x-arr.get(low)>arr.get(high)-x))
		        			low++;
		        		else 
		        			;
		        	
		        	
		        }
		        	return arr.subList(low, high+1);
		 }
	        
    }
}