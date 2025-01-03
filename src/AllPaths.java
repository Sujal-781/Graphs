import java.util.ArrayList;
import java.util.*;

public class AllPaths {
    public static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
        graph[6].add(new Edge(6,5));
    }
    public static void bfs(ArrayList<Edge> graph[],int v){
        Queue<Integer> queue=new LinkedList<>();
        boolean vis[]=new boolean[v];
        queue.add(0);
        while(!queue.isEmpty()){
            int curr=queue.remove();
            if(vis[curr]==false){
                System.out.print(curr+" ");                 //Step 1
                vis[curr]=true;                             //Step 2
                for(int i=0;i<graph[curr].size();i++){      //Step 3
                    Edge e=graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    public static void printAllPaths(ArrayList<Edge> graph[],boolean[] vis,int curr,String path,int tar){
        if(curr==tar){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                vis[curr]=true;
                printAllPaths(graph,vis,e.dest,path+e.dest,tar);
                vis[curr]=false;
            }
        }
    }


    public static void main(String[] args) {
        int v=7;

        /*
                1 --- 3
               /      | \
              0       |  5 -- 6
               \      | /
                2 --- 4
         */


        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        boolean vis[]=new boolean[v];
        printAllPaths(graph,vis,0,"0",5);
    }
}