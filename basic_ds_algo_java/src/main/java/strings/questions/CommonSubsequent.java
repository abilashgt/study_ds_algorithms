package strings.questions;

/*

Programming Challenge Description:
Given two strings, write a program to determine the longest common subsequence between them. Each string can have a maximum length of 50 characters. Note, this subsequence need not be contiguous.
Input:
Your program should read lines of text from standard input. Ignore empty lines. Each non-empty line will contain two semicolon-seperated strings. You can assume that there is only one unique subsequence per line.
Output:
For each line of input, print to standard output the longest common subsequence. Ensure that there are no trailing spaces on each line you print.

input:
XMJYAUZ;MZJAWXU

output:
MJAU

 */

public class CommonSubsequent {
    public static void main(String[] args) {
        String[] str = "XMJYAUZ;MZJAWXU".split(";");
        solve(str[0], str[1]);
    }

    public static void solve(String str1, String str2){
        String longest = "";
        for(int i = 0; i<str1.length(); i++){
            String longestTemp = subString(i, str1, str2);

            if(longest.length()<longestTemp.length()){
                longest = longestTemp;
            }
        }

        System.out.println("Output:"+longest);
    }

    public static String subString(Integer start, String str1, String str2){
        String longest = "";
        for(int i = start, j = 0; i<str1.length() & j<str2.length(); ){
            for(int k = j; k < str2.length(); k++) {
                if (str1.charAt(i) == str2.charAt(k)) {
                    longest += str1.charAt(i);
                    //System.out.println(str1.charAt(i) + " - " + str2.charAt(k));
                    i++; j=k+1;
                }

                if(i>=str1.length()){
                    break;
                }
            }
            i++;
        }

        System.out.println("sub:"+longest);
        return longest;
    }
}
