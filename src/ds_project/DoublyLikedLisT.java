package ds_project;

public class DoublyLikedLisT {

    private Node head;
    private Node tail;
    int size;

    public boolean isEmpty() {
        return (head == null);
    }

    public void displaywithsortbyfirstName() {
        Node curr = new Node();
        Node temp = new Node();
        curr = head;
        temp = head.next;
        while (head.next != null) {

            System.out.println(curr.data.Compare(curr.data, temp.data));
            head = head.next;
        }

    }

    public void insertFirst(Contact data) {
        try {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            newNode.prev = null;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            size++;
        } catch (Exception NullPointerException) {
            System.out.println("invalid ");
        }
    }

    // used to insert a node at the start of linked list
    public void insertLast(Contact data) {
        try {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = null;
            newNode.prev = tail;
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            if (head == null) {
                head = newNode;
            }
            size++;
        } catch (Exception NullPointerException) {
            System.out.println("invalid ");
        }

    }

    // Use to delete node after particular node
    public void deleteAfter(Node after) {
        Node temp = head;
        while (temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next.next.prev = temp;
        }
        temp.next = temp.next.next;

    }

//    Define a node current which will point to head.
//Define another node index which will point to node next to current.
//Compare data of current and index node. If the current's data is greater than the index's data, then swap the data between them.
//Current will point to current.next and index will point to index.next.
//Continue this process till the entire list is sorted.
    // For printing Doubly Linked List forward
    public void printLinkedListForward() {
        System.out.println("Printing Doubly LinkedList (head --> tail) ");
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }

    // For printing Doubly Linked List forward
    public void printLinkedListBackward() {
        System.out.println("Printing Doubly LinkedList (tail --> head) ");
        Node current = tail;
        while (current != null) {
            current.displayNodeData();
            current = current.prev;
        }
        System.out.println();
    }
}
