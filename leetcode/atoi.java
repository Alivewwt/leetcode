package project.leetcode;
/*
 * 实现一个atoi函数来把字符串转换为整形变量
 */
public class atoi {
	/*
	 * 考虑首尾空格
	 * 考虑数值正负
	 * 考虑无效字符
	 * 如果数值小于或大于Integer的值，则返回Integer的值
	 */
	public int myAtoi(String str){
		if(str==null||str.length()==0)
			return 0;
			str=str.trim();
		char[] charArray=str.toCharArray();
		Long result=0L;
		int startIndex=0;
		boolean flag=true;//true
		int length=0;
		for(int i=0;i<charArray.length;i++){
			if(startIndex==i){
				if(charArray[i]=='+'||charArray[i]=='0'){
					continue;
				}
				if(charArray[i]=='-'){
					flag=false;
					continue;
				}
				if(charArray[i]==' '){
					startIndex++;
					continue;
				}
			}
			if(charArray[i]>='0'&&charArray[i]<='9'){
				result=result*10+charArray[i]-'0';
				length++;
				if(length>10){
					break;
				}
			}else{
				break;
			}
		
		}
		if(!flag)
		{
			result=-result;
			if(result<Integer.MIN_VALUE){
				return Integer.MIN_VALUE;
			}
		}else
		{
			if(result>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		}
		return result.intValue();
	}
}
