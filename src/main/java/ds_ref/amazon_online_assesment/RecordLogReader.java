package ds_ref.amazon_online_assesment;

import java.util.*;

class Age{
    int id;
    Age(int id){
        this.id=id;
    }
    public String toString(){
        return ""+this.id;
    }
}
public class RecordLogReader implements Comparator<Age>{

    /*
    You can go either go for ascending sort or descending sort
    If you need descending  sort in compare method
     check for a<b if true return 1 else return -1
   If you need ascending  sort in compare method
     check for a<b if true return -1 else return 1
    With a descending sort, when the first item is less than the second item return a positive number,
    and when the first item is greater than the second item, return a negative number. This will create a descending order.

    //generally
    if return ==0 // nothing will happen original order will be maintained.
    if return ==1// values will be swapped.
    if return ==-1 //need to keep in same order
     */

    public int compare(Age a1, Age a2){
        if(a1.id < a2.id) return 1;
        else return -1;

    }

    void swapRecordReader(){
        //dig1 8 1 5 1
        //dig1 9 1 5 1
        //let1 art can
        //let2 own kit dig
        /*
            let say we get dig1 8 1 5 1  and dig1 9 1 5 1
            so sc1 = 8
               sc2 = 9
               if sc1 <='8' and sc2 <= '9' do nothing return 0
           let say we get dig1 8 1 5 1  and dig1 ab 1 5 1
               sc1 = 8
               sc2 = a
               if sc1 <='8' and sc2 <= '9' so swap it return 1
           let say we get dig1 ab 1 5 1  and dig1 8 1 5 1
               sc1 = a
               sc2 = 8
               do nothing same order return -1
           let say we get dig1 ab 1 5 1  and dig1 ac 1 5 1
                sc1.substring(ab 1 5 1).compareTo( ac 1 5 1) if the value is 0
                then sc1.substring(ab).compareTo(ac)


         */
    }
    public static void main(String[] args) {
        RecordLogReader rr=new RecordLogReader();
        Age a1=new Age(10);
        Age a2=new Age(11);
        Age a3=new Age(9);
        Age a4=new Age(12);
        List<Age> aa=new ArrayList<>();
        aa.add(a1);
        aa.add(a2);
        aa.add(a3);
        aa.add(a4);
        Collections.sort(aa,rr);
        System.out.println(aa);
    }
}
