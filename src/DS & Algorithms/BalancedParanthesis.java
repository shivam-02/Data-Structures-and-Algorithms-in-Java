import java.util.Stack;

public class BalancedParanthesis {

    static boolean isMatchingPair(char c1, char c2) {

        if (c1 == '(' && c2 == ')')
            return true;
        if (c1 == '{' && c2 == '}')
            return true;
        if (c1 == '[' && c2 == ']')
            return true;
        return false;
    }

    public static boolean areParanthesisBalanced(String exp) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                s.push(c);
            if (c == ')' || c == '}' || c == ']')
                if (s.isEmpty()) {
                    return false;
                }
                else if (!isMatchingPair(s.pop(),c)) {
                    return false;
                }
        }
        if (s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char exp[] = {'{', '(', ')', '}', '[', ']'};
        if (areParanthesisBalanced(exp.toString()))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
