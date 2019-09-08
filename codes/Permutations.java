/*For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs=new ArrayList<List<Integer>>();
        List<Integer> item =new ArrayList<Integer>();
        boolean[] visited=new boolean[nums.length];
        bp(nums,rs,item,visited);
    return rs;
    }
    
    public void bp(int[] nums,List<List<Integer>> rs,List<Integer> item,boolean[] visited){
        if(item.size()==nums.length){
            rs.add(new ArrayList(item));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                item.add(nums[i]);
                visited[i]=true;
                bp(nums,rs,item,visited);
                item.remove(item.size()-1);
                visited[i]=false;
            }
        }
    }
}