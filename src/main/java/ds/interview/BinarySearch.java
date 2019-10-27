package ds.interview;

public class BinarySearch {

    //take low
    //take high
    //take mid =low+high/2

    //if val > a[mid]
      //low = mid+1
    //height remains same

    //again calcualte mid
    // if val <= a[mid]
     // high=mid-1 ,low remains same

    //iterative
  /*
     --take arrayOfelments, size, key to be searched
     --returns index of elements found
      binarySearch(A,n,key)
        low = 1
        high = n
        mid=low+high/2
--low should never cross high
--so run as long as low <= high
        key==a[mid] found key < a[mid] high=mid-1 else low=mid+1
   */

    //recursive

    /*
        search(low,high,key)
        //check for single element ,beause we dont want to make it big
        //for single element l and h are same
        if(l == h){
          if(a[l] == key return l else return 0;
        }
        else{

        }
     */



}
