import java.util.LinkedList;
import java.util.Scanner;

public class graph {
    private  LinkedList<Integer> adjacency[];
    public graph(int v){
        adjacency = new LinkedList[v];
        for(int i = 0; i< v; i++){
            adjacency[i] = new LinkedList<Integer>();
        }
    }
    public void insertedge(int s , int d){
        adjacency[s].add(d);
        adjacency[d].add(s);

        System.out.println(adjacency[d]);
        System.out.println(adjacency[s]);

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Vertices  and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph g = new graph(v);
        System.out.println("Enter edge");
        for(int i =0;i<e;i++)
        {
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.insertedge(s,d);
    
        }
    
    }
}


