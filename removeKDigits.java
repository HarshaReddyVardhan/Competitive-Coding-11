// Time Complexity : O(n), where n is the length of num; each digit is pushed to and popped from the stack at most once.
// Space Complexity : O(n) for the stack and the output StringBuilder in the worst case (when the number is already minimal/monotonic).
// Did this code successfully run on Leetcode : Yes

// Approach
// Use a monotonic increasing stack to greedily remove larger preceding digits when a smaller digit arrives and k > 0.
// Traverse the string: for each digit c, pop from the stack while the top is greater than c and you still have removals left, then push c.
// If removals remain after the scan (i.e., number is non-decreasing), pop the last k digits from the stack.
// Build the result by iterating the stack from bottom to top, skipping leading zeros to avoid numbers like "0012".
// If all digits are removed or only zeros remain, return "0"; otherwise, return the constructed minimal number.

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!st.isEmpty() && st.peek() > c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            if (flag && c == '0')
                continue;
            flag = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
