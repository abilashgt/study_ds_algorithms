package expressions;

import java.util.Stack;

public class ValidateSimple {

    public static void main(String[] args) {
        String expression = "[()]{}{[()()]()}";
        //String expression = "[()]{}{[()()]()";

        if(validate(expression)){
            System.out.println("\n\nExpression good!");
        }
        else{
            System.out.println("\n\nExpression invalid!");
        }
    }

    public static Boolean validate(String expression){
        Stack stack = new Stack<Character>();

        for(int i = 0; i<expression.length(); i++){

            Character symbol = expression.charAt(i);

            if(symbol == '{' || symbol == '[' || symbol == '(') {
                System.out.print(" . push:"+symbol);
                stack.push(symbol);
            }
            else {
                Character oldSymbol = (Character) stack.pop();
                System.out.print(" . pop:"+oldSymbol);
                if (symbol == '}') {
                    if (oldSymbol != '{') {
                        return false;
                    }
                } else if (symbol == ']') {
                    if (oldSymbol != '[') {
                        return false;
                    }
                } else if (symbol == ')') {
                    if (oldSymbol != '(') {
                        return false;
                    }
                }
            }
        }

        // check if symbol left to process
        if(!stack.empty()){
            return false;
        }

        return true;
    }

}
