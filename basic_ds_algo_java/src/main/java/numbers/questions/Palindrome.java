package numbers.questions;

public class Palindrome {
    public static void main(String[] args) {
        int num = 5012;
        int palindrome = 0;

        while(num != 0){
            int digit = num % 10;
            num = num/10;
            palindrome = palindrome*10 + digit;
        }

        System.out.println(palindrome);
    }
}
