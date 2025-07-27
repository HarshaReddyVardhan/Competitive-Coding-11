// Time Complexity : O(n), where n is the number of tokens in the input array.
// Space Complexity : O(n), in the worst case, all tokens are numbers and pushed onto the stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues. Just had to ensure operator order (for '-' and '/') is correct.

// Your code here along with comments explaining your approach:

class Solution {
    public int evalRPN(String[] tokens) {
        // Stack to hold operands
        Stack<Integer> st = new Stack<>();
        
        // Iterate through all tokens
        for (int i = 0; i < tokens.length; ++i) {
            String x = tokens[i];
            
            // If current token is an operator
            if (x.equals("+")) {
                int a = st.pop(); // second operand
                int b = st.pop(); // first operand
                st.push(b + a);
            } else if (x.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a); // order matters: b - a
            } else if (x.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b * a);
            } else if (x.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a); // order matters: b / a
            } else {
                // It's a number, push to stack
                int val = Integer.parseInt(x);
                st.push(val);
            }
        }

        // Final result is the only item left on the stack
        return st.peek();
    }
}
