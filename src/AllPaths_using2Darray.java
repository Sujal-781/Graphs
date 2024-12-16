import java.util.ArrayList;

public class AllPaths_using2Darray {

    public static ArrayList<ArrayList<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> curr=new ArrayList<>();
        curr.add(0);
        dfs(0,curr,ans,graph);
        return ans;
    }
    public static void dfs(int src,ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> ans,int[][] graph){
        if(src==graph.length-1){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<graph[src].length;i++){
            curr.add(graph[src][i]);
            dfs(graph[src][i],curr,ans,graph);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        int graph[][]={{1,2},{3},{3},{}};
        ArrayList<ArrayList<Integer>> ans=allPathsSourceTarget(graph);
        System.out.println(ans);
    }
}
