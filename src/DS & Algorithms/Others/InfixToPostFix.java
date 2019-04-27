import java.util.Stack;

public class InfixToPostFix {

    public static int Precedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '%':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    public static String infixToPostfix(String exp){
        String result=new String("");
        Stack<Character> s=new Stack<>();

        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            } else if(c=='('){
                s.push(c);
            } else if(c==')'){
                while(!s.empty() && s.peek()!='('){
                    result+=s.pop();
                }
                if(!s.empty() && s.peek()!='(') return "INVALID EXPRESSION";
                else s.pop();

            } else{
                while(!s.empty() && Precedence(c)<=Precedence(s.peek())){
                    result+=s.pop();
                }
                s.push(c);
            }
        }
        while(!s.empty())
            result+=s.pop();
        return result;
    }
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
