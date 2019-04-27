package Graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SnakeAndLadder {
    static class qentry {
        int v;
        int dist;
    }

    static int getMinDiceThrows(int move[], int n) {
        boolean visited[] = new boolean[n];
        Queue<qentry> queue = new LinkedList<>();
        visited[0] = true;
        qentry qe = new qentry();
        qe.v = 0;
        qe.dist = 0;
        queue.add(qe);
        while (!queue.isEmpty()) {
            qe = queue.poll();
            int v = qe.v;
            if (v == n - 1)
                break;
            for (int j = v + 1; j <= v + 6 && j < n; j++) {
                if (!visited[j]) {
                    qentry a = new qentry();
                    a.dist = qe.dist + 1;
                    visited[j] = true;
                    if (move[j] == -1)
                        a.v = j;
                    else
                        a.v = move[j];
                    queue.add(a);
                }
            }
        }
        return qe.dist;
    }

    public static void main(String[] args) {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }

}
