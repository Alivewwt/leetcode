package alogrithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by wuwt
 * @date 2020/4/25 8:52 下午
 * 全排列
 **/
public class permute_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        boolean visited[] = new boolean[nums.length];
        dfs(nums,res,new ArrayList<Integer>(),visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, boolean[] visited) {
        if(temp.size()==nums.length)
            res.add(new ArrayList<>(temp));
        for(int i=0;i<nums.length;i++){
            if(visited[i]==true) continue;
            visited[i] = true;
            temp.add(nums[i]);
            dfs(nums,res,temp,visited);
            visited[i]=false;
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) {
        int nums[] ={1,2,3};
        List<List<Integer>> res = new permute_46().permute(nums);
        for(List<Integer> l :res){
            System.out.println(l);
        }
    }

}
