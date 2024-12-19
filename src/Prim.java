import java.util.*;
public class Prim {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();//If I don,t do this null pointer exception is shown
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,3,40));
        graph[1].add(new Edge(1,0,10));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
        graph[3].add(new Edge(3,0,30));
    }

    public static int PrimsAlgorithm(ArrayList<Edge> graph[]){
        int cost=0;
        boolean[] visited=new boolean[graph.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            if(!visited[arr[0]]){
                visited[arr[0]]=true;
                cost+=arr[1];
                for(int i=0;i<graph[arr[0]].size();i++){
                    Edge e=graph[arr[0]].get(i);
                    if(!visited[e.dest]){
                        pq.offer(new int[]{e.dest,e.wt});
                    }
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);

        System.out.println(PrimsAlgorithm(graph));
    }
}
