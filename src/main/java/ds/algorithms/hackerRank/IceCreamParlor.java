package ds.algorithms.hackerRank;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
 *
 * For example, they have m = 6 and cost = [1,3,4,5,6] then 1+5 =8 index are 0 and 3
 * crieria is 1 based indexing so value is 1 and 4
 *
 * algo
 *  m = x + y
 *  x is the element in array
 *  m = 6
 *  so we need to find y in the array
 *
 *  y=m-x // if this value exist in the array then return that index
 *
 *  create a map and put key as value and value as index
 *  for each elemetn in array
 *   y=m-x and check y is there in the map if not put it or get it back
 *
 */
public class IceCreamParlor {

    static int[] icecreamParlor(int m, int[] arr) {
        int[] result = new int[2];
       Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int y=m-arr[i];
            if(map.containsKey(y)){
                result[0]=i+1;
                result[1]=map.get(y)+1;
            }else{
                map.put(arr[i],i);
            }
        }
        return result;
    }

}
