/*
 题目；https://leetcode.com/problems/3sum-closest/description/
For example, given array S = [-1, 0, 1, 2, -1, -4],and target=1

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class solution{
	List<List<Integer>> ret=new ArrayList<List<Integer>>();
	public List<List<Integer>> threeSum(int[] num){
		if(num==null||num.length<3)
			return ret;
		
		Arrays.sort(num);
		int len=num.length;
		for(int i=0;i<len-2;i++){
			if(i>0&&num[i]==num[i-1])
				continue;
			//寻找两个数与num[i]的和为0
			find(num,i+1,len-1,num[i]);
		}
		return ret;
		
	}
	public void find(int[] num,int begin,int end,int target){
		int l=begin,r=end;
		while(l<r){
			if(num[l]+num[r]+target==0){
				List<Integer> ans=new ArrayList<Integer>();
				ans.add(target); 
				ans.add(num[l]);
				ans.add(num[r]);
				ret.add(ans);
				while(l<r&&num[l]==num[l+1])
					l++;
				while(l<r&&num[r]==num[r-1])
					r--;
				
				l++;
				r--;
			}else if(num[l]+num[r]+target<0){
				l++;
			}else{
				r--;
			}
		}
	}
}