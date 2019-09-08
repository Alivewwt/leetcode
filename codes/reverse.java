package project.leetcode;

/*
*题目:https://leetcode.com/problems/reverse-integer/description/
*数字交换位置，如123，返回321
*/

public class reverse {
	public static int reverse(int x){
		if(x>Integer.MAX_VALUE||x<Integer.MIN_VALUE)
			return 0;
		String s=String.valueOf(x);
		if(s.length()==1)
			return x;
		char ch=s.charAt(0);
		int b;
		long res = 0;		
		x=Math.abs(x);
		while(x!=0){
			 b=x%10;
			 res=res*10+b;
			 x/=10;
		}
		if(ch=='-'){
			res=-res;
		}
		
		if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)
			return 0;
		return (int)res;
	}
	/*
	 * 	long res = 0;
		int b;
		while(x!=0){
			 b=x%10;
			 res=res*10+b;
			 x/=10;
		}
		
		if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)
			return 0;
		return (int)res;
	 */
}
