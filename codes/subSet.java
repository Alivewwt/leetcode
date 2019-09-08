/*
生成子串
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> res=new ArrayList<Integer>();
        bp(list,res,nums,0);
        return list;
    }
    public void bp(List<List<Integer>> list,List<Integer> temp,int[] nums,int start){
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            bp(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        
        }
    }
}