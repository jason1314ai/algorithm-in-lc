/**
 * LC 394: https://leetcode.com/problems/decode-string/
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * 
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc
*/

/**
 * 思路：类似括号的问题 two stacks or recursion
 * 
*/
import java.util.*;

public class DecodeString { 
    public String decodeStringWishStack(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strings = new Stack<>();
        int index = 0;
        int number = 1;
        while(index < s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                number = 0;
                while(Character.isDigit(s.charAt(index))){
                    number = number * 10 + (s.charAt(index)-'0');
                    index++;
                }
            }else if(Character.isLetter(c)){
                nums.push(number);
                strings.push(c + "");
                number = 1;
                index++;
            }else if(c == '['){
                strings.push("[");
                nums.push(number);
                number = 1;
                index++;
            }else{
                String n = "";
                while(!strings.peek().equals("[")){
                    int num = nums.pop();
                    String target = strings.pop();
                    while(num > 0){
                        n = target + n;
                        num--;
                    }
                }
                strings.pop();
                strings.push(n);
                number = 1;
                index++;
            }
        }
        String ans = "";
        while(!nums.isEmpty()){
            int num  = nums.pop();
            String target = strings.pop();
            while(num > 0){
                ans = target + ans;
                num--;
            }
        }
        return ans;
    }

    public String decodeStringWithRecursion(String s) {
        int num = 1;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < s.length()){
            char c =  s.charAt(index);
            if(Character.isLetter(c)){
                for(int i = 0;i<num;i++){
                    sb.append(c);   
                }
                num = 1;
                index++;
            }else if(Character.isDigit(c)){
                num  = 0;
                while(Character.isDigit(s.charAt(index))){
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
            }else if(c == '['){
                int start = ++index;
                int count = 1;
                while(count != 0){
                    if(s.charAt(index) == '[')
                        count++;
                    else if(s.charAt(index) == ']')
                        count--;
                    index++;
                }
                String subOfS = decodeStringWithRecursion(s.substring(start,index-1));
                for(int i = 0;i<num;i++){
                    sb.append(subOfS);
                }
                num = 1;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
