import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        list.get(1).add(2);
        list.get(1).add(3);

        list.get(2).add(1);
        list.get(2).add(4);
        list.get(2).add(5);

        list.get(3).add(1);
        list.get(3).add(4);

        list.get(4).add(2);
        list.get(4).add(3);
        list.get(4).add(5);

        list.get(5).add(2);
        list.get(5).add(4);

        System.out.println(bfs(list, 5));
    }

    private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> list, int v) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v + 1];

        queue.offer(1);
        visited[1] = true;  // ✅ mark visited here

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int neighbor : list.get(node)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;  // ✅ avoid duplicate visits
                }
            }
        }

        return ans;
    }
}
