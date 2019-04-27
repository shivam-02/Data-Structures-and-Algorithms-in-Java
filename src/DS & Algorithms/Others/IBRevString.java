import java.util.PriorityQueue;
import java.util.Queue;

public class IBRevString {

    public static void main(String gg[]){
        String s="aabb";
        String res=""+s.charAt(0);
        int i;
        boolean yes=true;
        Queue<Character> q=new PriorityQueue<>();
        for(i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                q.add(s.charAt(i));
                continue;
            } else{
                res=res+s.charAt(i);
                if(!q.isEmpty())res=res+q.poll();
            }
        }
        while(!q.isEmpty()){
            if(res.charAt(res.length()-1)==q.poll()){
                yes=false;
                System.out.println("Not possible");
                break;
            } else {

                res=res+q.poll();
            }
        }
        if(yes)System.out.print(res);
    }
}
