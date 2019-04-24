package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    int V;
    LinkedList<Integer> adjArray[];

    TopologicalSort(int V) {
        this.V = V;
        this.adjArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            this.adjArray[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int src, int dest) {
        this.adjArray[src].add(dest);
    }

    public void topologicalSort() {

        boolean visited[] = new boolean[this.V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < this.V; i++) {
            if (visited[i] == false) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        System.out.print("Topological sorting is  ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> itr = this.adjArray[v].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                topologicalSortUtil(n, visited, stack);
            }
        }
        stack.push(new Integer(v));
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
