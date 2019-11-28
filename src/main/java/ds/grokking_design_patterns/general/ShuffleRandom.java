package ds.grokking_design_patterns.general;

/*
I need to build a function that returns a given number shuffled writing one digit from the front of the number and the following taken from the back, then the 3rd digit from the front of the number and the 4th from the back and so on.

Example:

const initialNumber = 123456 should return const finalNumber = 162534
 */

/**
 * 1 mod 2 = 1
 */

/*
  Array : 123456
  output : 1
 */
public class ShuffleRandom {

    static String shuffle(int num){
        char[] ch=String.valueOf(num).toCharArray();
        String result="";
        for(int i=0;i<ch.length;i++){
            //even indices
            if(i%2==0){
                System.out.println("in mod"+i);
                result += ch[(int)Math.floor(i/2)];
            }else{
                //odd indices
                System.out.println(i);
                result += ch[ch.length - (int)Math.floor(i/2+1)];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1/2 +" "+Math.ceil(3.2));
        System.out.println(shuffle(123456));
        System.out.println(shuffle(104));

    }
}
