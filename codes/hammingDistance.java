package project.leetcode;
/*
* 题目:https://leetcode.com/problems/total-hamming-distance/description/
* 两个数字之间的汉明距离就是其二进制数对应位不同的个数，
* 那么最直接了当的做法就是按位分别取出两个数对应位上的数并异或
*/
public class hammingDistance {
	public static int hammingDistance(int x, int y) {
        if(x<=0||x>Integer.MAX_VALUE)
        	return 0;
        String xy=Integer.toBinaryString(x^y);
        int count=0;
        for(int i=0;i<xy.length();i++)
        	if(xy.charAt(i)=='1')
        		count++;
       return count;
    }
	
}
