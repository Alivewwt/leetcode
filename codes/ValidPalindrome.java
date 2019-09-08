package algorithm;

/**
 * @author wuwt
 * @date 2019-05-06
 **/
public class ValidPalindrome {


    public static boolean isPalindOne(String s){
        if(s==null||s.length()==0)
            return true;
        int low = 0;
        int high =s.length()-1;
        while(low<=high){
            char left = s.charAt(low);
            char right = s.charAt(high);
            if(!Character.isLetterOrDigit(left))
                low++;
            else if(!Character.isLetterOrDigit(right))
                high--;
            else if(Character.toLowerCase(left)!=Character.toLowerCase(right))
                return false;
            else{
                low++;
                high--;
            }
        }
        return true;

    }


    public static boolean isPalindTwo(String s){
        if(s.length()==0||s==null)
            return true;
        String s1 = s.toLowerCase();
        int low = 0;
        int high = s1.length()-1;
        while(low<=high){
            // 可以删除一个字母，到底是删除左边，还是右边
            if(s1.charAt(low)!=s1.charAt(high)){
                return isValid(s1,low+1,high)||isValid(s1,low,high-1);
            }
            low++;
            high--;
        }
        return true;

    }

    public static boolean isValid(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindOne(s));
        String s1 = "abca";
        System.out.println(isPalindTwo(s1));
    }
}
