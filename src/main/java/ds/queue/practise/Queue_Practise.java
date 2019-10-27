package ds.queue.practise;

public class Queue_Practise {

    int array[];

    int topOfQueue = -1;

    int beginningOfQueue = -1;

    Queue_Practise(int size){
        array=new int[size];
    }
    public void enQueue(int value) {
        if(isQueueFull()){
            System.out.println("Queue is full");
        }else if(isQueueEmpty()){
            beginningOfQueue =0;
            topOfQueue++;
            array[topOfQueue]=value;
            System.out.println("value inserted");
        }else{
            topOfQueue++;
            array[topOfQueue]=value;
            System.out.println("value inserted");
        }
        printQueue();
    }

    public void printQueue() {
        System.out.println("Queue now");
        for (int i = beginningOfQueue; i <= topOfQueue; i++) {
            System.out.println(array[i]);

        }
    }

    public void deQueue() {
        if(isQueueEmpty()){
            System.out.println("Queue is empty and cannot be dequeued");
        }else{

            System.out.println(beginningOfQueue+" "+ topOfQueue+" Element deque "+array[beginningOfQueue]);
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue){
                beginningOfQueue = topOfQueue = -1;
            }
        }
    }

    public boolean isQueueEmpty() {
        if(beginningOfQueue == -1 || beginningOfQueue == array.length){
            return true;
        }
        return false;
    }

    public boolean isQueueFull() {
        if(topOfQueue == array.length -1){
            return true;
        }
        return false;
    }

    public void peekOperation() {
        if(isQueueEmpty()){
            System.out.println("Queue is empty and cannot be dequeued");
        }else{
            System.out.println(array[beginningOfQueue]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Creating an empty queue...");
        Queue_Practise queue = new Queue_Practise(5);

        System.out.println("Enqueuing 6 values in the queue...");
        for (int i = 1; i <= 6; i++) {
            queue.enQueue(i * 10);
        }

        System.out.println("Peek value from queue...");
        queue.peekOperation();

        System.out.println("Dequeue 6 values from queue...");
        for (int i = 0; i <= 5; i++) {
            queue.deQueue();
        }

        System.out.println("Deleting the entire Queue...");
        //queue.deleteQueue();
    }
}
