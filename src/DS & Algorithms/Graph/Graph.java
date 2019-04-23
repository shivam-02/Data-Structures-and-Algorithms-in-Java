package Graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V;
    LinkedList<Integer> edges[];

    Graph(int V) {
        this.V = V;
        this.edges = new LinkedList[this.V];
        for (int i = 0; i < this.V; i++) {
            this.edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        this.edges[src].add(dest);
        this.edges[dest].add(src);
    }

    public void printGraph() {
        for (int i = 0; i < this.V; i++) {
            Iterator<Integer> itr = this.edges[i].iterator();
            System.out.print(" Edges from vertex " + i + "-->");
            while (itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.print("\n");
        }
    }

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[this.V];
        visited[v] = true;
        q.add(v);
        while (q.size() != 0) {
            int temp = q.poll();
            System.out.print(temp + " ");

            Iterator<Integer> itr = this.edges[temp].iterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public void DFS() {
        boolean visited[] = new boolean[this.V];
        for (int i = 0; i < this.V; i++) {
            if (visited[i] == false) {
                DFSUtil(i, visited);
            }
        }
    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> itr = this.edges[v].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (visited[n] == false) {
                DFSUtil(n, visited);
            }
        }
    }

    public static void main(String gg[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.printGraph();
        g.BFS(2);
        System.out.println();
        g.DFS();
    }
}
