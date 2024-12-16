import java.util.ArrayList;

public class CycleDetection_Cyclic {
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
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
    }


    //Function for cycle detection

    public static boolean isCyclic(ArrayList<Edge> graph[],int curr,boolean[] vis,boolean[] rec){
        vis[curr]=true;
        rec[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(rec[e.dest]){               //if number is already in recursion stack, cycle exists
                return true;
            }
            else if(!vis[e.dest]){
                if(isCyclic(graph,e.dest,vis,rec))
                    return true;
            }
        }
        rec[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        boolean[] vis=new boolean[4];
        boolean[] rec=new boolean[4];
        int c=0;
        for(int i=0;i<4;i++){                //this is done so that if there are broken parts in graph they are addressed too
            if(isCyclic(graph,i,vis,rec)){
                System.out.println("true");
                c=1;
                break;
            }
        }
        if(c==0){
            System.out.println("false");
        }
    }
}
