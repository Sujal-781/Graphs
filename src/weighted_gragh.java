import java.util.ArrayList;

class Pair{
    int destination;
    int weight;
    public Pair(int dest,int wt){
        this.destination = dest;
        this.weight = wt;
    }

    @Override
    public String toString(){
        return "("+destination+","+weight+")";
    }
}

public class weighted_gragh {

    public static void main(String[] args) {
        int n=5,m=6;
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();

        for (int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        list.get(1).add(new Pair(2,4));
        list.get(1).add(new Pair(3,7));

        list.get(2).add(new Pair(1,4));
        list.get(2).add(new Pair(4,10));
        list.get(2).add(new Pair(4,9));

        list.get(3).add(new Pair(1,3));
        list.get(3).add(new Pair(4,7));

        list.get(4).add(new Pair(2,9));
        list.get(4).add(new Pair(3,1));
        list.get(4).add(new Pair(5,8));

        list.get(5).add(new Pair(2,5));
        list.get(5).add(new Pair(4,6));

        for(int i=1;i<=n;i++){
            System.out.println("Node "+i+"-> "+list.get(i));
        }

    }
}
