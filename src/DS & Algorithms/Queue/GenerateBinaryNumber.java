package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumber {

    public static void generateBinaryNumber(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (n-- > 0) {
            String s1 = queue.poll();
            System.out.println(s1);
            //
            queue.add(s1 + "0");
            queue.add(s1 + "1");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        generateBinaryNumber(n);
    }
}
