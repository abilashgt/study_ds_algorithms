package arrays.questions;

/*
You are given an array of n integers and a target sum T. The goal is to determine whether or not there are two numbers x,y in A with x+y=T.

Reference:
http://k2code.blogspot.com/2012/01/given-integer-array-and-number-x-find.html
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSumProblem {
    public static void main(String[] args) {
        Integer a[] = {5, 12, 13, 17, 22, 39};

        for(int x: a){
            System.out.println(x);
        }

        // approach 1: binary search
        System.out.println("Approach 1: two loops - no algorithm below");

        // approach 2: Hash
        System.out.println("Approach 2: Hash");
        findPairOfSumUsingHash(a, 25);

        // approach 3: binary search
        System.out.println("Approach 3: Binary Search");
        System.out.println("Approach Custom:");
        findPairOfSumUsingBS(a, 25);
    }

    public static void findPairOfSumUsingHash(Integer a[], int T){
        HashSet<Integer> hashA = new HashSet();

        for(int i=0; i<a.length; i++){
            if(hashA.contains(T-a[i])) {
                System.out.println(a[i] + " " + (T-a[i]));
            }

            hashA.add(a[i]);
        }

    }

    public static void findPairOfSumUsingBS(Integer a[], int T){
        Arrays.sort(a);

        int left=0, right;

        right = a.length-1;

        // validations
        if(a[left]>=T || right<1){
            System.out.println("No result");
            return;
        }

        // find right
        while (a[right]>=T) {
            //System.out.println("a[right]<T");
            int mid = left + right / 2;

            if (a[mid] < T && a[mid + 1] >= T) {
                right = mid;
                break;
            }
            else if(a[mid] < T){
                left = mid;
            }
            else if(a[mid] >= T){
                right = mid;
            }
        }

        System.out.println("Right:"+right+" = "+a[right]);

        // validations
        if(right<1 || (a[right]+a[right-1])<T){
            System.out.println("No result");
            return;
        }

        // find sum
        left = 0;
        while(left<=right){
            int sum = a[left]+a[right];
            if(sum==T){
                System.out.println("Position "+ left +" & " + right +" = "+ T);
                return;
            }
            else if(sum>T){
                right--;
            }
            else {
                left++;
            }
        }


        System.out.println("No result");
        return;
    }
}
