package project.leetcode;

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
