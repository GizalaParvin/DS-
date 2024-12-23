
import java.util.Scanner;

public class link {
    //Node class  representing  node a linked list
    static class Node{
        int data;
        Node next;

        //Constructor to create a new node
        Node(int data){
            this.data = data;
            this.next =null;

        }
    }
    private Node head;

    //head of the linked list 
    public void creation() {
        int data,n;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Enter data: ");
            data =sc.nextInt();
            Node newnode = new Node(data);

            if(head ==null){
                head = newnode; //First node in the list
            }else{ 
                newnode.next =head; // insert at the beginning
                head = newnode;
            }
            System.out.print("Do you want to add more data? If yes press 1: ");
            n =sc.nextInt();

        }while (n ==1);
        sc.close(); // Close the Scanner resource
    }
    
    public void traverser(){
        Node temp = head;

        if(head ==null){
            System.out.println("Linked list does not exist");
        }
        else{
            System.out.print("Linked List");
            while (temp !=null){
                System.out.println(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(); //Move to a new line printing
        }
    }
    //Main method to test the funtionality 
    public static void main(String[] args) {
        link list =new link();
        list.creation();
        list.traverser();
    }
    
}
