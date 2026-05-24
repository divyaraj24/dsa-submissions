class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            if (token.length() > 1 || Character.isDigit(token.charAt(0))) st.push(Integer.parseInt(token));
            else {
                int a = st.pop();
                int b = st.pop();
                char op = token.charAt(0);

                switch (op) {
                    case '+':
                        st.push(b + a);
                        break;
                    case '-':
                        st.push(b - a);
                        break;
                    case '*':
                        st.push(b * a);
                        break;
                    case '/':
                        st.push(b / a);
                        break;
                }
            }
        }

        return st.peek();
    }
}