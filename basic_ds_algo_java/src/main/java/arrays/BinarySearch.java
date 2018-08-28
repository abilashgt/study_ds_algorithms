package arrays;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {5, 12, 13, 17, 22, 39};

        Arrays.sort(a);
        int left = 0, right = a.length-1;
        int res;

        res = search(a, 17, left, right);
        System.out.println(res+"=>"+a[res]);

        res = searchRecursion(a, 12, left, right);
        System.out.println(res+"=>"+a[res]);
    }

    public static int search(int a[], int aSearch, int left, int right){
        while(left<=right){
            int mid = (left + right)/2;
            //System.out.println(left+"-"+right+"-"+mid);

            if(a[mid] == aSearch){
                return mid;
            }
            else if(a[mid] > aSearch){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return -1;
    }

    public static int searchRecursion(int a[], int aSearch, int left, int right){
        if(left>right) {
            return -1;
        }

        int mid = (left + right)/2;
        //System.out.println(left+"-"+right+"-"+mid);

        if(a[mid] == aSearch){
            return mid;
        }
        else if(a[mid] < aSearch){
            left = mid+1;
        }
        else{
            right = mid-1;
        }

        return searchRecursion(a, aSearch, left, right);
    }
}
