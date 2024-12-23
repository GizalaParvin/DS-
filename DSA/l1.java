

public class l1 {
    Node head;
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data =data;
            this.next =null;
        }

    }
    //add - first ,last
    public void addFirst(String data){
        Node newNode =new Node(data);
        if(head ==null){
            head =newNode;
            return;

        }
        newNode.next =head;
        head =newNode;
    }
    //add last
    public void addLast(String data) {
        Node newNode =new Node(data);
        if(head ==null){
            head =newNode;
            return;

        }
        Node currNode =head;
        while(currNode.next !=null) {
            currNode =currNode.next;
        }
        currNode.next =newNode;

    }
    //print
    public void printList() {
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        Node currNode =head;
        while(currNode !=null) {
            System.out.println(currNode + " -> ");
            currNode =currNode.next;
        }
        System.out.println("Null");

    }


    public static void main(String[] args) {
        l1 list =new l1();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("List");
        list.printList();

        list.addFirst("this");
        list.printList();


    }

}
