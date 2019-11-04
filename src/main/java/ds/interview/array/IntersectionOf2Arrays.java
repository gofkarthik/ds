package ds.interview.array;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOf2Arrays {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] intersect = intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int i : intersect) {
            System.out.print(i+" ");
        }
    }
}
