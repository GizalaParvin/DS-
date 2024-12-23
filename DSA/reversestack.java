import java.util.Stack;
public class reversestack {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        st.push(1); 
        st.push(5); 
        st.push(9); 
        st.push(8); 
        st.push(2); 
        System.out.println(st);
        // reverse order
    //     Stack<Integer> rt = new Stack<>();
    //     while(st.size()>0){
    //         //int x = st.peek();
    //         // rt.push(x);
    //         // st.pop();
    //         rt.push(st.pop());
    //     }
    //     System.out.println(rt);
          Stack<Integer> gt = new Stack<>();
          while(st.size()>0) {
              gt.push(st.pop());
          }
          Stack<Integer> rt = new Stack<>();
          while(st.size()>0) {
              rt.push(st.pop());
          }
          System.out.println(rt);
    }
}
