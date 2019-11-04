package ds.interview.array;

public class ArrayRemoveDuplicates {


    //use temp array that is called extra space
    static int[] removeDuplicatesWithExtraSpace(int a[]){
        int[] temp=new int[a.length];
        //go up to -1 beause inside we are comparing index and index+1 to make sure no
        //out of bounds exception is thrown
        int j=0;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] != a[i+1]) {
                temp[j++]=a[i];
            }
        }
        //then put the last element
        temp[j]=a[a.length-1];
        return temp;
    }

    static  int[] removeDuplicatesWithoutExtraSpace(int a[]){
        //go up to -1 beause inside we are comparing index and index+1 to make sure no
        //out of bounds exception is thrown
        //go up to -1 beause inside we are comparing index and index+1 to make sure no
        //out of bounds exception is thrown
        int j=0;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] != a[i+1]) {
                a[j++]=a[i];
            }else{
                a[i]=0;
            }
        }
        //then put the last element
        a[j]=a[a.length-1];
        return a;
    }

    public static void main(String[] args) {
        int[] ints = removeDuplicatesWithExtraSpace(new int[]{1, 2, 2,3,4});
        for (int i = 0; i < ints.length; i++) {
            if(ints[i]!=0) {
                System.out.print(ints[i] + " ");
            }
        }
        System.out.println();
        ints = removeDuplicatesWithoutExtraSpace(new int[]{1, 2,3,4,5,5,5,5});
        for (int i = 0; i < ints.length; i++) {
            if(ints[i]!=0) {
                System.out.print(ints[i] + " ");
            }
        }
    }
}
