package ds.interview;

import java.util.Arrays;
import java.util.Comparator;

/*


Time Complexity: O(Alog⁡A) , where A is the total content of logs.

Space Complexity: O(A)

You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.

We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
Reorder the logs so that all of the letter-logs come before any digit-log.
The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
The digit-logs should be put in their original order.
Return the final order of the logs.


Algo
   Basically compartor swaps if it is 1  -1 doesnt swap and 0 for equal
   so in our case ..
   leave the first string
   take charachter of first and second string
   if first < = '9' and (second <= '9' return 0 do nothing,both are numbers
                        else  return 1(swap)) //because second is charachter

   if second <='9' then first is letter so do nothing return -1
   int val = s1.substring(first+1).compareTo(s1.substring+1) //this compares lexographic
   //both same then compare main string
   return s1.substrong(0,first).compareTo(0,second)
   return val

  */
public class ReorderDataLogfiles {



    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> compartor=new Comparator<String>(){

            public int compare(String s1,String s2){
                int sf1=s1.indexOf(" ");
                int sf2=s2.indexOf(" ");
                char sc1=s1.charAt(sf1+1);
                char sc2=s2.charAt(sf2+1);
                if(sc1 <= '9'){
                    if(sc2 <= '9') return 0;
                    else return 1;
                }
                if(sc2 <= '9'){
                    return -1;
                }
                int compute=s1.substring(sf1+1).compareTo(s2.substring(sf2+1));
                if(compute ==0) return s1.substring(0,sf1).compareTo(s2.substring(0,sf2));
                return compute;
            }


        };
        Arrays.sort(logs,compartor);
        return logs;
    }

    /*
      comparator is a simple logic
      For any condition if value is 1 it will swap if it is -1 it wont swap (forgot 0)
      let say 2 elements
      5 , 9
      if ascending
         we have to check a < b return -1 because nothing needs to be done else return 1
         let say a=5 b=9 5<9 false returns -1 output 5 ,9
         let say a=9 b=5 return true (1) so swap 5,9
         similary for descending
         b>a
         thats why they say b-a for descending because if value is -1 it wont swap
     */
    public static void main(String[] args) {

        Integer a[]={5,9,2,3,10};
        //sort(a);
        for (Integer i :a) {
            System.out.print(i + " ");
        }
        /*String a[]={"aa a art can","dig1 10 1 5 1","aaa b"};
        String[] strings = reorderLogFiles(a);
        for (String string : strings) {
            System.out.print(string + " ~ ");
        }*/
    }
}
