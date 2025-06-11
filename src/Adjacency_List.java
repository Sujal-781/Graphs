import java.util.ArrayList;

public class Adjacency_List {
    public static void main(String[] args) {
        int n = 5, m = 6;
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

        for (int i = 1; i <= n; i++) {
//            for(int j=0;j<list.get(i).size();j++){
//                System.out.print(list.get(i).get(j)+" ");
//            }
//            System.out.println();
            System.out.println(list.get(i));
        }
    }
}
