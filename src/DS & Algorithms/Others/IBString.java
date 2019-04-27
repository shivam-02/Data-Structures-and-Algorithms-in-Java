import java.util.HashSet;

public class IBString {
    public static void main(String gg[]) {

        String str = " quick brown fox jumps over the lazy dog";

        boolean[] mark = new boolean[26];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {

            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                index = str.charAt(i) - 'A';

            }
            if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                index = str.charAt(i) - 'a';

            }
            mark[index] = true;

        }

        int j;
        for (j = 0; j < mark.length; j++) {
            if (mark[j] == false) {
                System.out.println("Not a panagram");
                break;
            }
        }
        if (j == mark.length) System.out.println("A panagram");
    }
}
