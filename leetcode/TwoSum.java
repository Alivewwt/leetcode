/*
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
public class solution{
	 public static int[] twoSum(int[] nums, int target) {
        if(nums==null)
        	return null;
        int res[]=new int[2];
        Map< Integer, Integer> map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){       	
        	if(map.containsKey(target-nums[i])){
        		int r=target-nums[i];
        		res[1]=i;
        		res[0]=map.get(r);
        	}
            map.put(nums[i], i);
        }
        return res;
    }
}