package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleUndirected {
    int V;
    LinkedList<Integer> adjArray[];

    DetectCycleUndirected(int V) {
        this.V = V;
        this.adjArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            this.adjArray[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int src, int dest) {
        this.adjArray[src].add(dest);
    }

    public boolean isCyclic() {
        boolean visited[] = new boolean[this.V];
        for (int i = 0; i < this.V; i++) {
            if(!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;

        Iterator<Integer> itr = adjArray[v].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n])
                return isCyclicUtil(n, visited, v);
            else if (n != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUndirected g1 = new DetectCycleUndirected(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        DetectCycleUndirected g2 = new DetectCycleUndirected(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}
