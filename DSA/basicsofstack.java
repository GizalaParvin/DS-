import java.util.Scanner;
import java.util.Stack;
public class basicsofstack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //unlimited size / O(1) 
        Stack<Integer> st = new Stack<>();
        int n;
        System.out.println("Enter the number of elements you want to insert");
        // System.out.println(st.isEmpty());
        // System.out.println();
        // System.out.println("size is: "+st.size());
        // System.out.println(st);
        // st.push(1);
        // System.out.println(st.isEmpty());
        // System.out.println("size is: "+st.size());
        // System.out.println(st);
        // st.push(23);
        // System.out.println("size is: "+st.size());
        // System.out.println(st);
        // st.push(90);
        // st.push(5);
        // st.push(34);
        // System.out.println(st.peek());
        // System.out.println(st);
        n = sc.nextInt();
        System.out.println("Enter the elements");
        for(int i =1;i<=n;i++){
            int x = sc.nextInt();
            st.push(x);
        }
        System.out.println(st);
    }
}
