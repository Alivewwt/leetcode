package project.leetcode;
/*
 * 将数字转换成罗马数字表示
 */
public class integerToRoman {
	public String intToRoman(int num) {
        if(num<=0)
        	return "";
        int[] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] dict={"M","CM","D","CD","C","XC","L","XL","x","IX","V","IV","I"};
        String res="";
        for(int i=0;num!=0;i++){
        	if(num>=val[i]){
        		int count=num/val[i];
        		num%=val[i];
        		for(int j=0;j<count;j++){
        			res+=dict[j];
        		}
        	}
        	
        }
        return res;
    }
}
