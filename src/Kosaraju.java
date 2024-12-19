import java.util.*;
public class Kosaraju {
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
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }

    //Step 1 -> Create stack using Topological sort

    public static void createStack(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer> stack){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest]) {
                createStack(graph, visited, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[],boolean[] visited,int curr){
        visited[curr]=true;
        System.out.print(curr);

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph,visited,e.dest);
            }
        }
    }


    public static void KosarajuAlgo(ArrayList<Edge> graph[],int v){


        //Step 1
        boolean[] visited=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                createStack(graph,visited,i,stack);
            }
        }


        //Step 2
        ArrayList<Edge> transpose[]=new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            visited[i]=false;              //reusing the visited array in step 3
            transpose[i]=new ArrayList<Edge>();//If I don,t do this null pointer exception is shown
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();i++){
                Edge e=graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }


        //Step 3
        while(!stack.isEmpty()){
            int curr=stack.pop();
            if(!visited[curr]){
                dfs(transpose,visited,curr);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);

        KosarajuAlgo(graph,v);


    }
}
