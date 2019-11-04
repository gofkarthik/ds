package ds.interview.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
   array 1 -> O(n)

   array 2 -> O(m)

   result is O(n+m)

   if not sorted

   result is O(nlogn+mlogm)

   space not considering the result should be O(1)
 */
public class UnionAndIntersecionArrays {

    //time complexity O(n+m) and space complexity O(n+m)
    static int[] union(int[] a, int[] b) {
        HashSet<Integer> ab = new HashSet<>();
        for (int i : a) {
            ab.add(i);
        }
        for (int i : b) {
            ab.add(i);
        }
        int[] result = new int[ab.size()];
        int count = 0;
        for (Integer i : ab) {
            result[count++] = i;
        }
        return result;
    }

    //if given sorted ..else add sorted
    //O(nlogn + mlogm)
    //space will be O(1) ignoring the result array
    //this wont avoid duplicates
    static int[] union_notsorted(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else if (b[j] < a[i]) {
                result[k++] = b[j++];
            } else if (b[j] == a[i]) {
                result[k++] = b[j++];
                i++;
            }
        }
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    static int[] intersection(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (b[j] < a[i]) {
                j++;
            } else if (b[j] == a[i]) {
                result[k++] = b[j++];
                i++;
            }
        }
        /*while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }*/

        return result;
    }

    //avoid duplicates
    static int[] intersections(int[] l1, int[] l2) {
        Arrays.sort(l1);
        Arrays.sort(l2);
        int[] res=new int[l1.length+l2.length];
        int l = 0, r = 0,k=0;
        while (l < l1.length && r < l2.length) {
          int left = l1[l], right = l2[r];
            if (left == right) {
                //dont put negative and 0
                if(right > 0) {
                    res[k++] = right;
                }
                while (l < l1.length && left == l1[l]) l++;
                while (r < l2.length && right == l2[r]) r++;
                continue;
            }
            if (right > left) while (l < l1.length && left == l1[l]) l++;
            else while (r < l2.length && right == l2[r]) r++;

        }
        return res;
    }


    public static void main(String[] args) {
        //int[] union = union(new int[]{1, 2, 3, 5}, new int[]{9, 8, 6, 1, 2, 3});
        //int[] union = union_notsorted(new int[]{1, 2, 3, 5}, new int[]{9, 8, 6, 1, 2, 3, 3, 3});
  //      int[] union = intersection_avoid_duplicates(new int[]{9,8}, new int[]{9, 8});
        //int[] union = intersection(new int[]{9,8,7,8,9,10,11,12}, new int[]{9, 8,9,10,11});
        int[] union = intersections(new int[]{9,8,0,7,8,9,19,10,11,12}, new int[]{0,9,8,9,10,11,13,14,19});
        for (int i : union) {
            //if (i != 0) {
                System.out.print(i + " ");
            //}
        }
    }
}
