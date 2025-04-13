import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the string array and if its a dight push it into the stack else if its an operator, take the 2 elements out of the stack
 * and do calculation with operator and put that result into the stack. Finally return st.pop().
 */

class ReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack= new Stack<>();
        Set<String> set= new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String s: tokens)
        {
            if(set.contains(s))
            {
                int first= stack.pop();
                int second= stack.pop();

                if(s.equals("+"))
                {
                    stack.push(second+first);
                }
                else if(s.equals("-"))
                {
                    stack.push(second-first);
                }

                else if(s.equals("*"))
                {
                    stack.push(second*first);
                }

                else if(s.equals("/"))
                {
                    stack.push(second/first);
                }
            }

            else
                stack.push(Integer.parseInt(s));
        }

        return stack.pop();
    }
}