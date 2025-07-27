// Time Complexity : O(n), where n is the number of tokens
// Space Complexity : O(n), for storing numbers in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// - Needed to handle negative numbers carefully (isdigit(x[0]) isn't enough for negatives)
// - Ensured correct operand order in subtraction and division (b - a, b / a)

// Your code here along with comments explaining your approach:

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int n = tokens.size();
        stack<int> st;

        // Loop through all tokens
        for (int i = 0; i < n; ++i) {
            string x = tokens[i];

            // Check if the token is an operator
            // Note: need to handle negative numbers, so check x.size() == 1 as well
            if (!isdigit(x[0]) && x.length() == 1) {
                // Pop top two numbers from stack
                int a = st.top(); st.pop();
                int b = st.top(); st.pop();
                // Perform the operation and push result back
                st.push(performOperation(x, a, b));
            } else {
                // Convert operand string to integer and push to stack
                st.push(stoi(x));
            }
        }

        // Final result is on top of the stack
        return st.top();
    }

    // Helper function to perform the given operation
    int performOperation(string x, int a, int b) {
        switch (x[0]) {
        case '+': return a + b;
        case '-': return b - a;
        case '*': return a * b;
        case '/': return b / a;
        }
        return 0; // should never reach here if input is valid
    }
};
