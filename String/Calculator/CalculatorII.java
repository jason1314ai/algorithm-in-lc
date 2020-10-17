/**
 * LC 227 : https://leetcode.com/problems/basic-calculator-ii/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * 
*/

/**
 * 思路：比 I和III 都要简单一,单个stack就可以 因为不用记录()
 * 遇到 * / stack pop一个计算后再push
 * 
*/
import java.util.*;
public class CalculatorII {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
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
                    num  = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                if(sign == '+'){
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if(sign == '*'){
                    st.push(st.pop() * num);
                }else{
                    st.push(st.pop() / num);
                }
            }else{
                sign = c;
                index++;
            }
        }
        int res = 0;
        for(int n : st){
            res += n;
        }
        return res;
    }     
}
