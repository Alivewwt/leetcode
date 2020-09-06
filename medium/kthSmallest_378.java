package alogrithm.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author created by wuwt
 * @date 2020/7/4 10:58 下午
 *  有序矩阵中第K小的元素
 **/
public class kthSmallest_378 {

    public int kthSmallest(int[][] matrix, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        int n = matrix.length;
        for(int i=0;i<n;i++){
            pq.offer(new int[]{matrix[i][0],i,0});
        }

        for(int i=0;i<k-1;i++){
            int[] now = pq.poll();
            if(now[2]!=n-1){
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];

    }

}
