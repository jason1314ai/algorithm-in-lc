/**
 * LC 224 : https://leetcode.com/problems/basic-calculator/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * 
*/
/**
 * 思路： 有括号的问题一般 用stack或者recursion 去括号 
 * ------------------------------------ 
 * Stack:
 * 因为有 Integer 和 sign，所以可以用两个stack，或者用一个string(数字计算是重复遍历)
 * 存一个integer 存一个sign
 * 遇到 '('  存sign 和 '('
 * 遇到 ')' 计算数字直到遇到 '('
 * 
 * ------------------------------------ 
 * 
 * Recursion: 
 * 遇到括号用 recursion计算括号内内容
*/ 

import java.util.*;
public class CalculatorI{
    // Using two stacks
    public int calculateWithTwoStacks(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> signs = new Stack<>();
        int index = 0;
        char sign = '+';
        while(index < s.length()){
            char c = s.charAt(index);
            if(c == ' '){
                index++;
                continue;
            }
            if(Character.isDigit(c)){
                int num = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    num = num * 10 + (s.charAt(index)-'0');
                    index++;
                }
                nums.push(num);
                signs.push(sign);
            }else if(c == '+' || c == '-'){
                sign = c;
                index ++;
            }else if( c == '('){
                signs.push(sign);
                signs.push('(');
                sign = '+';
                index ++;
            }else{
                int num = 0;
                while(signs.peek() != '('){
                    int value = nums.pop();
                    char m = signs.pop();
                    if(m == '-')
                        num -= value;
                    else
                        num += value;
                }
                signs.pop();
                nums.push(num);
                index ++;
            }
        }
        int ans = 0;
        while(!nums.isEmpty()){
            int value = nums.pop();
            char m = signs.pop();
            if(m == '-')
                ans -= value;
            else
                ans += value;            
        }
        return ans;
    }


    public int calculateWithRecursion(String s) {
        int ans = 0;
        int index = 0;
        char sign = '+'; 
        while(index < s.length()){
            char c = s.charAt(index);
            if(c == ' '){
                index++;
                continue;
            }
            
            if(Character.isDigit(c)){
                int num = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                if(sign  == '-'){
                    ans -= num;
                }else{
                    ans += num;
                }
            }else if(c == '+' || c == '-'){
                sign = c;
                index++;
            }else if(c == '('){
                int count = 0;
                int start = index;
                while(index < s.length()){
                    if(s.charAt(index) == '(')
                        count++;
                    if(s.charAt(index) == ')')
                        count--;
                    if(count == 0)
                        break;
                    index++;
                }
                int num = calculate(s.substring(start+1,index));
                if(sign  == '-'){
                    ans -= num;
                }else{
                    ans += num;
                }
                index++;
            }
        }
        return ans;
    }

}