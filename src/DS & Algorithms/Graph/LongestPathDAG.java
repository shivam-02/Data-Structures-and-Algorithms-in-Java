package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class LongestPathDAG {
    static class AdjNode {
        int v;
        int weight;

        AdjNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    int V;
    LinkedList<AdjNode> adjNodes[];

    LongestPathDAG(int V) {
        this.V = V;
        this.adjNodes = new LinkedList[this.V];
        for (int i = 0; i < this.V; i++) {
            adjNodes[i] = new LinkedList<AdjNode>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        AdjNode node = new AdjNode(dest, weight);
        this.adjNodes[src].add(node);
    }

    public void longestPath(int s) {
        boolean visited[] = new boolean[this.V];
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[this.V];

        for (int i = 0; i < this.V; i++) {
            dist[i] = Integer.MIN_VALUE;
        }
        dist[s] = 0;

        for (int i = 0; i < this.V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                Iterator<AdjNode> itr = this.adjNodes[u].iterator();
                while (itr.hasNext()) {
                    AdjNode node = itr.next();
                    int v = node.getV();
                    if (dist[v] < dist[u] + node.getWeight()) {
                        dist[v] = dist[u] + node.getWeight();
                    }
                }
            }
        }
        for (int i : dist) {
            if (i == Integer.MIN_VALUE) {
                System.out.print("Infinity ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Iterator<AdjNode> itr = this.adjNodes[v].iterator();
        while (itr.hasNext()) {
            AdjNode node = itr.next();
            if (!visited[node.getV()])
                topologicalSortUtil(node.getV(), visited, stack);
        }
        stack.push(new Integer(v));
    }

    public static void main(String gg[]) {
        LongestPathDAG g = new LongestPathDAG(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        System.out.println("Longest path distance is ");
        g.longestPath(1);
    }
}
