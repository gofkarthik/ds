package ds.grokking_design_patterns.amazon;

public class LongestPalindrome {

    private static String longestPalindrome(String s){
        int length=s.length();
        if(s== null || length <2 ){
            return  s;
        }

        boolean [][] isPalindrome = new boolean[length][length];
        int left = 0;
        int right=0;
        for(int j=1;j<length;j++){
            for(int i=0;i<j;i++){
                boolean isInnerPalindrome = isPalindrome[i+1][j-1] || j-i <=2;
                if(isPalindrome[i+1][j-1] ){
                    System.out.println(i + " "+j);
                }
                 if(s.charAt(i) == s.charAt(j) && isInnerPalindrome){
                     isPalindrome[i][j]=true;
                     if(j-i > right-left){
                         left=i;
                         right=j;
                     }
                 }
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
