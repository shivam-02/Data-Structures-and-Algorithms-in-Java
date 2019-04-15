import java.util.Stack;

public class InfixToPostfix2 {

    static int Prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(')
                    result += s.pop();
                if (!s.isEmpty() && s.peek() != '(')
                    System.out.println("Invalid expression");
                else
                    s.pop();

            } else {
                while (!s.isEmpty() && Prec(c) <= Prec(s.peek()))
                    result += s.pop();
                s.push(c);
            }

        }
        while (!s.isEmpty())
            result += s.pop();
        return result;
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
