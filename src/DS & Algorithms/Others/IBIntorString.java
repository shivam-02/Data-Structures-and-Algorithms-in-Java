public class IBIntorString {

    public static void main(String gg[]){
        String s="299999a";
        boolean isInteger=true;

        for(int i=0;i<s.length();i++){
            int a=(int)s.charAt(i);
            if(a<48 || a>57){
                isInteger=false;
                break;
            }
        }
        if(isInteger)System.out.println("yes its a integer");
        else System.out.println("No its a string");
    }
}
