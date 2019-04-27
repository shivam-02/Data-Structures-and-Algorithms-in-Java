import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IBGraph {
    int V;
    LinkedList<Integer> arr[];

    IBGraph(int V) {
        this.V = V;
        arr = new LinkedList[V];
        for (int i = 0; i < V; i++)
            arr[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest) {
        this.arr[src].add(dest);
        this.arr[dest].add(src);
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[this.V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.peek();
            System.out.print(s + " ");
            queue.poll();
            Iterator<Integer> iterator = this.arr[s].iterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (visited[n] != true) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

    public void DFSUtil(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        Iterator<Integer> itr = arr[i].iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (visited[n] == false) {
                DFSUtil(n, visited);
            }
        }
    }

    public void DFS() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                DFSUtil(i, visited);
        }
    }

    public boolean isCyclic(){
        boolean visited[]=new boolean[this.V];
        boolean recStack[]=new boolean[this.V];
        for(int i=0;i<V;i++){
            visited[i]=false;
            recStack[i]=false;
        }
        for(int i=0;i<V;i++){
            if(isCyclicUtil(i,visited,recStack))
                return true;
        }
        return false;
    }

    public boolean isCyclicUtil(int i,boolean[] visited,boolean[] recStack){
        if(visited[i]==false){
            visited[i]=true;
            recStack[i]=true;
            List<Integer> children=arr[i];
            for(int v:children){
                if(!visited[v] && isCyclicUtil(v,visited,recStack))
                    return true;
                else if(recStack[v])
                    return true;
            }
        }
        recStack[i]=false;
        return false;
    }

    public void printGraph(IBGraph graph) {
        for (int i = 0; i < this.V; i++) {
            System.out.print("Adjaceny list of vertex " + i + " ->");
            for (Integer j : arr[i]) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String gg[]) {
      /*  IBGraph g = new IBGraph(4);
        g.addEdge(g, 0, 1);
        g.addEdge(g, 0, 2);
        g.addEdge(g, 1, 2);
        g.addEdge(g, 2, 0);
        g.addEdge(g, 2, 3);
        g.addEdge(g, 3, 3);
        System.out.println("Following is Depth First Traversal");
        g.DFS();*/
        IBGraph graph = new IBGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}

