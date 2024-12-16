import java.util.*;
public class Topological_Sort {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();//If I don,t do this null pointer exception is shown
        }
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void TopoSort(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> stack){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                TopoSort(graph,e.dest,vis,stack);
            }
        }
        stack.push(curr);
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        boolean[] vis=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<v;i++){                  //If this is not done answer will be wrong as for 0
            if(vis[i]==false){                 //graph is unable to proceed further as it is connected to nothing
                TopoSort(graph,i,vis,stack);
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(stack.pop());
        }

    }
}
