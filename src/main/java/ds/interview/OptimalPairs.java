package ds.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value.
Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible.
Return a list of ids of selected elements. If no pair is possible, return an empty list.

Algo
 swap the second element in both arrays in ascending (a-b)
 start 2 pointers
 one from 0 to < n of first array
 list <result>
 max = 0
 second from n-1 to >=0 of secomd array //while
  get sum of i and j
 if sum > target j-- else
 max <= sum{ max=sum;result.clear();}
 //add the result
 now make j-1
 moeve from result.add-> all other elements of j
 */
public class OptimalPairs {

    private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] i, int[] j) {
                return i[1] - j[1];
            }
        });
        Collections.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] i, int[] j) {
                return i[1] - j[1];
            }
        });
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i =0;
        int j =n-1;
        while(i<m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if(sum > target) {
                --j;
            } else {
                if(max <= sum) {
                    if(max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j-1;
                    while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                ++i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> aa=new ArrayList<>();
        List<int[]> bb=new ArrayList<>();

        /*
        a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7
        Output: [[2, 1]]
Explanation:
There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
         */
        aa.add(new int[]{1,2});
        aa.add(new int[]{2,4});
        aa.add(new int[]{3,6});
        bb.add(new int[]{1,2});
/*
        Input:
        a = [[1, 3], [2, 5], [3, 7], [4, 10]]
        b = [[1, 2], [2, 3], [3, 4], [4, 5]]
        target = 10

        Output: [[2, 4], [3, 2]]

        Explanation:
        There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
        Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
        These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].*/

        List<int[]> pairs = getPairs(aa, bb, 7);
        for (int[] pair : pairs) {
            for (int i : pair) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        aa=new ArrayList<>();
        bb=new ArrayList<>();
        aa.add(new int[]{1,3});
        aa.add(new int[]{2,5});
        aa.add(new int[]{3,7});
        aa.add(new int[]{4,10});
        bb.add(new int[]{1,2});
        bb.add(new int[]{2,3});
        bb.add(new int[]{3,4});
        bb.add(new int[]{4,5});

        pairs = getPairs(aa, bb, 10);
        for (int[] pair : pairs) {
            for (int i : pair) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
