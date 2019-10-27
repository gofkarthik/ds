package ds.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * An array of logs
 * First word in log is alpha numeric
 * Continuation word is either lower case letter or consist of only ditits
 * Guaranteed : one word after identifier
 * Record log all letter logs comes before any digit log
 *
 * Alphanumericals are a combination of alphabetical and numerical characters,
 *
 * Return final order of the logs
 * lexicographically -In mathematics, the lexicographic or lexicographical order is a generalization of the way words
 * are alphabetically ordered based on the alphabetical order of their component letters.
 *
 * Java uses  java.util.TimeSort (which is basically return A stable, adaptive, iterative mergesort that requires far fewer than
 *  * n lg(n) comparisons )
 *  basically on a given 2 objects if 1 is compared to 2 it goes by ascending and if 2 compared to 1 it goes by descending
 *  based on value 1 , 0 and -1
 */

// Java uses TimSort, a hybrid sorting algorithm, derived from merge sort and insertion sort, designed to perform well on many kinds of real-world data. It's space O(n).

    //https://www.geeksforgeeks.org/timsort/
/*


Time Complexity: O(Alog⁡A)O(\mathcal{A}\log \mathcal{A})O(AlogA), where A\mathcal{A}A is the total content of logs.

Space Complexity: O(A)O(\mathcal{A})O(A).
 */

class ComparatorExample{

}

public class RecordDataReader {


    //basically Arrays.sort by default goes in ascending order
    //Comparator sort method take 2 args a,b
    // if returns -1 it always considers ascending (a comes first then b)
    // if return +1 it always considers descending (b comes first then a)
    //if operation is on a-b (then ascending) (because it happens on a first)
    //if operation is on b-b (then descending) (because it happens on b first)
    //so -1 will come first then 0 and then 1

    //so bascially in a method if argument is "dig1 8 1 5 1","dig2 a 6" then return 1(compare 8 and a)
    // or if argument is "dig1 a 1 5 1","dig2 8 6" return -1 (compare a and 8)
    //if both number then return 1 or 0 else return natural order (because by defaul it goes in ascending order

    //so for each compare methoed whichever has -1 will come first then 0 and then 1
    //so in compare method return -1 if that it needs to come in ascending
    //not in this problem statement it doesnt matter dig1 8 1 5 1 and dig2 3 6 it only matter this comes first let3 art zero
    //so basically algo is
    //take the charachter after first space and if both is number return 0 else return 1 because it needs descending
    //else return -1
    //if it is
     static String[] reorderLogFiles(String[] logs) {

         //dig1 8 1 5 1 dig2 a 6
         Comparator<String> ss=new Comparator<String>() {

             public int compare(String a,String b){
                 int index1=a.indexOf(' ');
                 int index2=b.indexOf(' ');
                 char s1=a.charAt(index1+1);
                 char s2=b.charAt(index2+1);
                 if(s1 <= '9'){
                     if(s2 <= '9'){
                         return 0;
                     }
                     return 1;
                 }
                 if(s2 <= '9'){
                     return -1;
                 }
                 int comparison = a.substring(index1 + 1).compareTo(b.substring(index2 + 1));
                 if(comparison == 0){
                     return a.substring(0,index1).compareTo(b.substring(0,index2));
                 }
                 return comparison;
             }
         };

         Arrays.sort(logs,ss);
         return logs;
    }

    public static void main(String[] args) {


        String[] a={"a2aa aat","a1aa art"};
        //String[] a={"dig1 8 1 5 1","dig2 a 6"};
        reorderLogFiles(a);
        for (String s : a) {
            System.out.println(s);
        }
        //Comparator example
        //return -1 ,0 ,1
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(111, "bbbb", "london"));

      //  ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new Sortbyroll());

        System.out.println("\nSorted by rollno");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));

        /*Collections.sort(ar, new Sortbyname());

        System.out.println("\nSorted by name");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));*/
    }

}

class Student
{
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name,
                   String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()
    public String toString()
    {
        return this.rollno + " " + this.name +
                " " + this.address;
    }
}

class Sortbyroll implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        System.out.println(String.format("value of  %d and %d is %d",a.rollno,b.rollno,(a.rollno - b.rollno)));
        //ascending
        //return a.rollno - b.rollno;
        //descending
        //return b.rollno - a.rollno;
        return -1;
    }
}

class Sortbyname implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll name
    public int compare(Student a, Student b)
    {
        return a.name.compareTo(b.name);
    }
}