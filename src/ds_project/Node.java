
package ds_project;

public class Node {
    public Contact data;
    public Node next;
    public Node prev;
 
    public void displayNodeData() {
        System.out.println("{ " + data + " } ");
    }
}
