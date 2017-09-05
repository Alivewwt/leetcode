package project.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 题目:https://leetcode.com/problems/binary-watch/description/
 * 二进制表
 * 1 2 4 8 时
 * 1 2 4 8 16 32 分
 * num 表示亮灯的个数，列出所有时间表示的可能。
 * 思路：两次循环，将小时和分钟分别用补码表示，Integer.bitCount(i)可以补码中1的个数
 */
public class BinaryWatch {
	 public List<String> readBinaryWatch(int num) {
	        List<String> res=new ArrayList<String>();
	        for(int i=0;i<12;i++){
	            for(int j=0;j<60;j++){
	                if(Integer.bitCount(i)+Integer.bitCount(j)==num){
	                    res.add(String.format("%d:%02d",i,j));
	                }
	            }
	        }
	        return res;
	    }
}
