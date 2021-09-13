/*
Replace all ‘0’ with ‘5’ in an input Integer

https://www.geeksforgeeks.org/replace-0-5-input-integer/
 */

package numbers.questions;

public class Replace0with5 {
    public static void main(String[] args) {
        int num = 5020;
        int newNum = 0;
        int count = 1;

        while(num != 0){
            int digit = num % 10;
            num = num/10;

            if(digit == 0) digit = 5;

            newNum = digit * count + newNum;
            count = count * 10;
        }

        System.out.println(newNum);
    }
}
