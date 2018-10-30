package strings.questions;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]

Reference:
https://leetcode.com/problems/remove-invalid-parentheses/description/

*/

import java.util.*;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        String input = "()()))()";
        Set<String> solution = new HashSet<String>();

        removeInvalid(input, solution);

        System.out.println("Solution: "+solution);
    }


    public static Set<String> removeInvalid(String input, Set<String> solution) {
        System.out.println("Input: "+input);

        Stack stack = new Stack();
        Stack<Integer> forPar = new Stack();
        Stack<Integer> backPar = new Stack();
        boolean isValid = true;

        //System.out.println("input length:"+ input.length());
        for(int i=0; i<input.length(); i++){
            String temp = input.charAt(i)+"";
            //System.out.println(temp);

            if(temp.equals("(")){
                forPar.push(i);
                stack.push(temp);
            }
            else if(temp.equals(")")){
                backPar.push(i);

                if(!stack.empty()){
                    stack.pop();
                }
                else if(isValid){
                    isValid = false;
                    break;
                }
            }
        }

        if(!stack.empty()){
            isValid = false;
        }

        if(isValid){
            System.out.println("Valid Input: "+input);
            solution.add(input);
            return solution;
        }

        // not valid
        Stack<Integer> invPar;
        //System.out.println("for size:"+forPar);
        //System.out.println("back size:"+backPar);
        if(backPar.size() > forPar.size()){
            invPar = backPar;
        }
        else {
            invPar = forPar;
        }

        Set<String> newInputs = new HashSet<String>();
        while (!invPar.empty()){
            int index = invPar.pop();
            //System.out.println("index: "+index);
            String out = input.substring(0, index)+input.substring(index+1, input.length());
            newInputs.add(out);
        }

        for (String newInput : newInputs) {
            removeInvalid(newInput, solution);
        }

        return  solution;
    }
}
