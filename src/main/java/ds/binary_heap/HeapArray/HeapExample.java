package ds.binary_heap.HeapArray;

public class HeapExample {

    int array[];

    int sizeOfTree;

    HeapExample(int size){
        array=new int[size];
        sizeOfTree=0;
    }

    boolean isTreeEmpty(){
        return sizeOfTree <= 0;
    }

    void printLevelOrder(){
        for (int i = 0; i <= sizeOfTree; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    void insertInHeap(int value){
            array[sizeOfTree+1]=value;
            sizeOfTree++;
            heapifyBottomToTop(sizeOfTree);
            printLevelOrder();
    }

    void heapifyBottomToTop(int index){
        int parent=index/2;
        if(index <= 1) return;
        if(array[parent] > array[index]){
            int temp=array[parent];
            array[parent]=array[index];
            array[index]=temp;
        }
        heapifyBottomToTop(parent);
    }

    int extractMinHeap(){
        if(!isTreeEmpty()){
            int value=array[1];
            array[1] =  array[sizeOfTree];
            sizeOfTree --;
            heapifyTopToBottom(1);
            printLevelOrder();
            return value;
        }
        return -1;
    }

    void heapifyTopToBottom(int index) {
        int left= index*2;
        int right= (index*2)+1;
        int smallestChild=0;
        if(sizeOfTree < left){
            return;
        }
        else if(sizeOfTree == left){
            if(array[index] > array[left]){
                int temp=array[index];
                array[index]=array[left];
                array[left]=temp;
            }
            return;
        }
        else{
            if(array[right] > array[left]) smallestChild = left;
            else smallestChild = right;
            if(array[index] > array[smallestChild]){
                int temp=array[index];
                array[index]=array[smallestChild];
                array[smallestChild]=temp;
            }
            heapifyTopToBottom(smallestChild);
        }
    }

    public static void main(String[] args) {
        System.out.println("Creating a blank Heap");
        HeapExample heap = new HeapExample(10);

        heap.insertInHeap(100);
        heap.insertInHeap(90);
        heap.insertInHeap(80);
        heap.insertInHeap(70);
        heap.insertInHeap(60);
        heap.insertInHeap(50);
        heap.insertInHeap(40);
        heap.insertInHeap(30);
        heap.insertInHeap(20);
        System.out.println("value extracted " + heap.extractMinHeap());
        heap.insertInHeap(110);
        System.out.println("value extracted " + heap.extractMinHeap());

    }
}
