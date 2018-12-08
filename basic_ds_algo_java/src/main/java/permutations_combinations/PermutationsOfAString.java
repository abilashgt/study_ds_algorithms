package permutations_combinations;


/*
A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a
one-to-one correspondence with S itself. A string of length n has n! permutation.

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB

Reference:
Mathword(http://mathworld.wolfram.com/Permutation.html)
https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */

public class PermutationsOfAString {

    public static void main(String[] args) {
        String input = "ABC";

        //System.out.println(swap(input, 1, 2));

        permute(input, 0, input.length()-1);

    }

    public static void permute(String input, int l, int r){
        if(l == r){
            System.out.println(input);
        }
        else {
            // fixing character
            for(int i=l; i<=r; i++){
                input = swap(input, l, i);
                permute(input, l+1, r);
                input = swap(input, l, i);
            }
        }
    }

    public static String swap(String input, int pos1, int pos2){
        char pos1Char = input.charAt(pos1);
        char pos2Char = input.charAt(pos2);

        StringBuilder temp = new StringBuilder(input);
        temp.setCharAt(pos1, pos2Char);
        temp.setCharAt(pos2, pos1Char);

        return temp.toString();
    }
}
