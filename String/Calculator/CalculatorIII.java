/**
 * LC 772 : https://leetcode.com/problems/basic-calculator-iii/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].
 * 
*/

/**
 * 思路： 类似calculatorI 
 * 先去除 * / () 
 * 然后在iterate stack 求解
 * 
 * -----------------------------------------------------
 * summary:
 * a. 如果只有 + -： 顺着计算
 * b. 如果加上乘除： 先算乘除，最后计算a -> int stack
 * c. 如果有括号，双stack遇到记录( 和 + - -> char stack 
 * 
*/

import java.util.*;

public class CalculatorIII {
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
                if(sign == '*' || sign == '/'){
                    if(sign == '*'){
                        num *= nums.pop();
                    }else{
                        num = nums.pop() / num;
                    }
                    nums.push(num);
                    continue;
                }
                nums.push(num);
                signs.push(sign);
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
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
                if(signs.peek() == '*' || signs.peek() == '/' ){
                    if(signs.peek() == '*' ){
                        num *= nums.pop();
                    }else{
                        num = nums.pop() / num;
                    }
                    signs.pop();
                }
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
}
