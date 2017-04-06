package project.leetcode;
/*
 * 盛水的最大容积
 * 从两边向中间考虑，盛水的面积是由（两端较小的高度）×（两个板之间的宽度）决定的
 * 假定初始的盛水面积是area=0,lh为左边的高度，rh为右边的高度，如果lh<rh，则向右运动，寻找第一个比lh大的节点。同理，如果lh>rh
 * ，则向左运动，寻找第一个比当前rh大的节点。
 * 截止坐标l>=r
 */
public class maxContainer {
	public int maxArea(int[] height) {
	        if(height==null||height.length<2)
	        	return 0;
	        int i,j,lh,rh,maxArea=0;
	        int len=height.length;
	        i=0;
	        j=len-1;
	        lh=height[0];
	        rh=height[len-1];
	        int temp;
	        while(i<j){
	        	temp=Math.min(lh, rh)*(j-i);
	        	if(temp>maxArea)
	        		maxArea=temp;
	        	
	        	if(lh<rh){
	        		while(i<j&&height[i]<=lh)
	        			i++;
	        		if(i<j){
	        			lh=height[i];
	        		}
	        	}else{
	        		while(i<j&&height[j]<=rh)
	        			j--;
	        		if(i<j){
	        			rh=height[j];
	        		}
	        	}
	        }
			return maxArea;
	    }
}
