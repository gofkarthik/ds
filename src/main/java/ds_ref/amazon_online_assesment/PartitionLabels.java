package ds_ref.amazon_online_assesment;

import java.util.List;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String s){
        int[] lastIndex=new int[26];
        for(int i=0;i<s.length();i++){
            System.out.println(i+" "+s.charAt(i)+" "+(s.charAt(i)-'a'));
            lastIndex[s.charAt(i)-'a']=i;
        }
        return null;
    }

    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklijzsvcbnjy");
    }
}
