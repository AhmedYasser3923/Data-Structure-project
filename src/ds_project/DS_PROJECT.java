package ds_project;

public class DS_PROJECT {

    public static void main(String[] args) {
        //  I. Phone Book Problem (Doubly Linked List)
        System.out.println("I. Phone Book Problem (Doubly Linked List) : ");
        System.out.println(".............................................");
        Contact Contact1 = new Contact("ziad", "khaled", "01248454");
        Contact Contact2 = new Contact("mohamed", "shafee", "6565655656");
        DoublyLikedLisT myLinkedlist = new DoublyLikedLisT();

        myLinkedlist.insertFirst(Contact1);
        myLinkedlist.insertFirst(Contact2);
        myLinkedlist.displaywithsortbyfirstName();
        System.out.println("______________________________________________________________\n");
        //  II. Printer Service (Queue)
        System.out.println("II. Printer Service (Queue) : ");
        System.out.println(".............................");
        Queue q = new Queue();

        q.enqueue(54);
        q.enqueue(27);
        q.enqueue(82);
        q.enqueue(23);
        q.enqueue(24);
        q.enqueue(1);
        q.enqueue(13);
        q.enqueue(89);
        q.enqueue(12);
        q.enqueue(234);
        q.enqueue(32);
        q.dequeue();
        q.enqueue(66);
        q.enqueue(18);
        q.close();
        
        System.out.println("_____________________________________________________________\n");
        //    Evaluating Arithmetic Expression (Trees)
        System.out.println("III.Evaluating Arithmetic Expression (Trees) : ");
        System.out.println("...........................................");
        Trees tr = new Trees();
        Trees tr2 = new Trees();
        Trees tr3 = new Trees();
        //infix
        System.out.print("First step : ");
        tr.insert("2*3/1");
        System.out.println(tr.evaluate());
        //postfix
        System.out.print("Second step : ");
        tr2.insert("545*-");
        System.out.println(tr2.evaluate());
        //prefix
        System.out.println("Final step : ");
        System.out.print("Ans : ");
        tr3.insert("*+356");
        System.out.println(tr3.evaluate());

    }

}
