package Graph;

import java.util.LinkedList;

public class UnionFind {
    int V;
    LinkedList<Integer> adjArr[];

    UnionFind(int V) {
        this.V = V;
        this.adjArr = new LinkedList[this.V];
        for (int i = 0; i < this.V; i++) {
            adjArr[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        this.adjArr[src].add(dest);
    }

    public int find(int parent[], int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public boolean isCyclic() {

        int[] parent = new int[this.V];
        for (int i = 0; i < this.V; i++)
            parent[i] = -1;

        for (int i = 0; i < this.V; i++) {
            int x = find(parent, i);
            int y = find(parent, i);
            if (x == y)
                return true;

            union(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        UnionFind graph = new UnionFind(V);

        // add edge 0-1
        graph.addEdge(0, 1);

        // add edge 1-2
        graph.addEdge(1, 2);
        // add edge 0-2
        graph.addEdge(0, 2);

        if (graph.isCyclic())
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }
}
