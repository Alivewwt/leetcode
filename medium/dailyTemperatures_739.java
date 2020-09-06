package alogrithm.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author created by wuwt
 * @date 2020/6/17 9:05 下午
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

 **/
public class dailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<length;i++){
            int current = T[i];
            while(!q.isEmpty() && current>T[q.peek()]){
                int pre = q.pop();
                result[pre] = i-pre;
            }
            q.push(i);

        }
        return result;

    }

    public static void main(String[] args) {
        dailyTemperatures_739 dt = new dailyTemperatures_739();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int res[]=  dt.dailyTemperatures(T);
        for(int r : res){
            System.out.println(r);
        }

    }
}
