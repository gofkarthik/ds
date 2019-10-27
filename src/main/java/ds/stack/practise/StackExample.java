package ds.stack.practise;

public class StackExample {

    private int topOfStack;

    int arr[];

    StackExample(int size) {
        this.arr = new int[size];
        topOfStack = -1;
    }

    boolean isStackFull() {
        if (topOfStack == arr.length - 1) {
            return true;
        }
        return false;
    }

    boolean isStackEmpty() {
        if (topOfStack == -1) {
            return true;
        }
        return false;
    }

    void push(int value) {
        if (isStackFull()) {
            System.out.println("Stack is full");
        } else {
            topOfStack++;
            System.out.println("putting value "+value +" at "+topOfStack);
            arr[topOfStack] = value;
        }
    }

    void pop() {
        if (isStackEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(arr[topOfStack]);
            topOfStack--;
        }
    }

    void peek() {
        System.out.println(arr[topOfStack]);
    }

    public static void main(String[] args) {

        System.out.println("Creating a stack of size 5...");
        StackExample stack = new StackExample(5);


        System.out.println("Pushing 6 values in the Stack...");
        for(int i=0; i<=5; i++) {
            stack.push(i*10);
        }


        System.out.println("Peeking value from stack");
        stack.peek();


        System.out.println("Poping 6 values from the Stack...");
        for(int i=0; i<=5; i++) {
            stack.pop();
        }

    }
}

