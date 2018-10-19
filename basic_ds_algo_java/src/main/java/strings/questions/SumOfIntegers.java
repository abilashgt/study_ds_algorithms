package strings.questions;


/*
* Return the sum of all integers from a random String. Continuous Integers must be considered as one number.
* If the input String does not have any Integers, return 0.
* You may ignore decimals, float, and other non-integer numbers
* @param str : Input String


* Given the following inputs, we expect the corresponding output:
* "1a2b3c" => 6        (1+2+3)
* "123ab!45c" => 168   (123+45)
* "abcdef" => 0        (no Integers in String)
* "0123.4" => 127      (0123+4)
*  "dFD$#23+++12@#T1234;/.,10"  => 1279  (23+12+1234+10)
*
*  additional:
* 12a-10b=>2
* 12a-b10 =>22

 */

public class SumOfIntegers {

    public static void main(String args[]){
        String input = "123ab!45c";
        //input = "12a-10b+1";

        Integer sum = sumOfIntegersOfString(input);

        System.out.println("Total Sum:"+sum);

        //additional case
        sum = 0;
        int sumLength = 0;
        for(String in: input.split("\\+|-")){
            if(sumLength<input.length() && input.charAt(sumLength)=='-'){
                sum -= sumOfIntegersOfString(in);
            }
            else{
                sum += sumOfIntegersOfString(in);
            }
            sumLength += in.length();
        }

        System.out.println("Total Sum more:"+sum);
    }

    public static Integer sumOfIntegersOfString(String input){
        Integer sum = 0;
        String intSum = "";


        for(int i=0; i<input.length(); i++){

            String temp = input.charAt(i)+"";

            if(convertStringToInteger(temp) == -1){
                int temp2 = convertStringToInteger(intSum);
                sum += (temp2==-1)?0:temp2;
                intSum = "";
            }
            else{
                intSum += temp;
            }


        } // end of loop

        int temp2 = convertStringToInteger(intSum);
        sum += (temp2==-1)?0:temp2;

        return sum;
    }


    public static Integer convertStringToInteger(String Input){

        try{
            return Integer.parseInt(Input);
        }
        catch(Exception e){

        }

        return -1;

    }

}
