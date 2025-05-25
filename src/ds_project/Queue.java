
package ds_project;


public class Queue {
   private int List[];
   private int time ;
   private int front;
   private int rear;
   private int count;
   private int capc;
 

    public Queue() {
        capc = 5;
        List = new int[capc];
        time = 0;
        front = 0;
        rear = -1;
        count = 0;
    }

    public Queue(int size, int List[],int front , int rear , int count) {
     this.capc = size;
     this.List = new int[capc];
     this.front = 0;
     this.rear = -1;
     this.count = 0;
    }

    public boolean isempty() {
        if (rear == -1) {
            System.out.println("Queue is Empty");
            return true;
        }
        return false;
    }

    public boolean isfull() {
        return (rear == capc - 1);
    }
    
    public int count(){
        return count;
    }
    
     public void expand() {
        int[] newArr = new int[List.length * 2];
        System.arraycopy(List, front, newArr, front, List.length);
        List = newArr;
    }
     
     
    public int getFront() {
        return List[front];
    }



    public void dequeue() {
        if (isempty()) {
            return;
        }

        for (int i = 0; i < rear; i++) {
            List[i] = List[i + 1];
        }
        rear--;
    }

    public void enqueue(int num) {
        if (num == 0) {
            time++;
            return;
        } else if (isfull()) {
            expand();
        }
        rear++;
        count++;
        List[rear] = num;
        time++;
        System.out.print("Time t = " + time);
        System.out.println(". A request for print job " + num + " is issued");
        if (time % 5 == 0) {
            System.out.print("Time t = " + (time));
            System.out.println(". Job " + getFront() + " is processed");
            count--;
            dequeue();
        }
    }
    
    public void close() {
        if(count > rear){
            System.out.println("company is close");
        }
        System.out.println("Remaining number of jobs in the queue: " + count);
    }
}
