/*
 For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class solution{
	//先排序，再左右夹逼
	public static int threeSumClosest(int num[],int target){
		if(num==null||num.length<3)
			return 0;
		Arrays.sort(num);
		int ret=0;
		int closestDist=Integer.MAX_VALUE;
		int length=num.length;
		for(int i=0;i<length-2;i++){
			if(i>0&&num[i]==num[i-1])
				continue;
			int l=i+1,r=length-1;
			while(l<r){
				int sum=num[i]+num[l]+num[r];
				if(sum<target){
					if(target-sum<closestDist){
						closestDist=target-sum;
						ret=sum;
					}
					l++;
				}else if(sum>target){
					if(sum-target<closestDist){
						closestDist=sum-target;
						ret=sum;
					}
					r--;
				}
				else{
					return sum;
				}
			}
		}
		return ret;
		//
	}
}