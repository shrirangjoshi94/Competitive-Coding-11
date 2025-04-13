import java.util.Stack;


// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the string and if the number is smaller than st.peek() then remove top element and push smaller element into the stack.
 * Remove elements only k times. Take all the elements of the stack into a string builder and reverse it and convert into a string. Check for
 * leading zeroes and if length is greaterthan n-k then take substring of size n-k from start. Finally return the result string.
 */

class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peek() > digit) {
                stack.pop();
                k -= 1;
            }
            stack.push(digit);
        }

        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.pop();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;

        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}