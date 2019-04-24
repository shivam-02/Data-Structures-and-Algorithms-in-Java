package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycle {
    int V;
    LinkedList<Integer> adjArray[];

    DetectCycle(int V) {
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
        boolean recStack[] = new boolean[this.V];
        for (int i = 0; i < this.V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;

        Iterator<Integer> itr = this.adjArray[i].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            return isCyclicUtil(n, visited, recStack);
        }
        recStack[i] = false;

        return false;
    }

    public static void main(String[] args) {
        DetectCycle graph = new DetectCycle(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}

