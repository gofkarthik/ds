package ds.algorithms.educative.strings;



/*
   Problem
   ========
    Reverse the order of words in a given sentence(an array of characters). Here are a few examples:
    "Hello World" -> "World Hello"
    "The quick brown fox jumped over the lazy dog." -> "dog. lazy the over jumped fox brown quick The"

   Time complexity O(n)
   Space complexity O(1)


Solution
=============
   Step 1
   =========
   Take the string and convert it to Array
   Make length of array has string length + 1 because last char should be \0
   while printing or looping check until \0


   Step 2
   =======
   Reverse the complete string ( "Hello World" -> "dlroW olleH".)
   reverse from 0 to len-2 as last char is \0
   Have a method which takes char array ,start ,end
   For ex  [Hello],0,4
   Iterate until start < end and swap and inrease start and decrease end
    temp = ch[0]//H
    ch[0]=end //o
    end=tmp


   Step 3
   ======
    Now char array has dlroW olleH\0
    delare start=0,end
    run infinite loop
    while(true)
    find start index letter with no space
    while(ch[start] == ' ') ++start
     start = d
     end = start+1 (l)
     move end until space
     while(ch[end] != '' && ch[end] != '\0']{
        ++end;
     }
     end=5
     strrev(ch,start,end-1) //this will revers World
     start=end (start will start from Oll

 */

public class StringReverse {


    static void  reverseStr(char[] ch,int start,int end){
        while(start < end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
    }

    public static void reverse_words (char[] sentence){
        char [] ch=sentence;
        reverseStr(ch,0,ch.length-1);
        int start=0;
        int end;
        while (true){

            if(start >= ch.length){
                break;
            }
            if(ch[start] == '\0') {
                break;
            }
            while(ch[start] == ' '){
                ++start;
            }
            end=start+1;
            try {

                while (ch[end] != '\0' && ch[end] != ' '){
                    ++end;
                    if(end >= ch.length){
                        break;
                    }

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            reverseStr(ch,start,end-1);
            start=end;
        }
    }
    static void getStringArray(String s, char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            ch[i] = s.charAt(i);
        }
    }

    static void print(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '\0') {
                System.out.print(ch[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "Quick brown fox jumped over the lazy dog";
        //char[] ch = new char[s.length() + 1];
        char[] ch = new char[s.length()];
        getStringArray(s, ch);
     //   print(ch);
        reverse_words(ch);
        print(ch);

    }
}
