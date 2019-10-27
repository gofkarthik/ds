package ds.algorithms.educative.strings;

import java.util.HashSet;

/*
remove duplicates in a string
Time and Space O(n)
Have 2 indices .. one read and one write
Write increas only if hashset doesnt have it
 */
public class RemoveDuplicates {



    static void remove_duplicates_1(char[] str){
        HashSet<Character> letters=new HashSet<>();
        int writeIndex=0;
        int readIndex=0;
        while(str[readIndex] != '\0'){
            if(!letters.contains(str[readIndex])){
                letters.add(str[readIndex]);
                str[writeIndex]=str[readIndex];
                writeIndex++;
            }
            readIndex++;
        }
        str[writeIndex]='\0';
    }

    static void print(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '\0') {
                System.out.print(ch[i]);
            }
        }
        System.out.println();
    }

    static void getStringArray(String s, char[] ch) {
        for (int i = 0; i < ch.length-1; i++) {
            ch[i] = s.charAt(i);
        }
    }

    public static void main(String[] args) {
        String s="aabbccddefffgfijk";
        char[] ch=new char[s.length()+1];
        getStringArray(s,ch);
        print(ch);
        System.out.println();
        remove_duplicates_1(ch);
        print(ch);
    }
}
