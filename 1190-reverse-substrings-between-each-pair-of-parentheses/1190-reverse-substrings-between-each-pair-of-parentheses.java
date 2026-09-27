class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                if (!st.isEmpty()) {
                    Deque<Character> temp = new ArrayDeque<>();

                    while (st.peek() != '(') {
                        temp.add(st.pop());
                    }

                    st.pop();

                    while (!temp.isEmpty()) {
                        st.push(temp.pop());
                    }
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty())
            res.append(st.pop());

        return res.reverse().toString();
    }
}