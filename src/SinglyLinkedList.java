/**
 * @ClassName:SinglyLinkedList
 * @Auther: yyj
 * @Description:
 * @Date: 03/01/2023 22:08
 * @Version: v1.0
 */
public class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    public Node headNode; //head node of the linked list
    public int size;      //size of the linked list

    //Constructor - initializes headNode and size
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    //Helper Function that checks if List is empty or not
    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public boolean searchNode(T data) {
        // Write -- Your -- Code
        Node head = this.headNode;
        while (head != null){
           if( head.data.equals(data)){
               return true;
           }
            head = head.nextNode;
        }
        return false; //value not found
    }
    //Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
        //if the list is empty then call insertATHead()
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        //iterate to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //make newNode the next element of the last node
        last.nextNode = newNode;
        size++;
    }
    public void deleteByValue(T data) {
        // Write -- Your -- Code
        if (isEmpty()) {
            deleteAtHead();
            return;
        }
        Node head = this.headNode;
        Node prev = null;

        if(head.data.equals(data)) {
            deleteAtHead();
            return;
        }
        while (head != null){
            if(head.data.equals(data)){
                prev.nextNode = head.nextNode;
                break;
            }
            prev = head;
            head = head.nextNode;
        }

    }

    private void deleteAtHead() {
    }
}