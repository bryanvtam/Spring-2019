package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userinput = new Scanner(System.in);
    	String holder = ("");
    	while (!holder.toUpperCase().equals("QUIT")) {
    		System.out.println("Please give a an expression:");
    		holder = (userinput.nextLine());
    		System.out.println(produceAnswer(holder));
    		
    	}
    	userinput.close();
    }

    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	// VARIABLES
        String operand1 = (input.split(" "))[0];
        String operation = (input.split(" "))[1];
        String operand2 = (input.split(" "))[2];
        int wholeN1 = 0;
        int wholeN2 = 0;
        int[] frac1 = {0,1};
        int[] frac2 = {0, 1};
        String answer = "";
        //SEPERATES OPERAND1 INTO WHOLEN NUMBER, NUMERATOR, & DENOMINATOR
        
        if(operand1.contains("_") ) { //checks if it is a mixed number
        	wholeN1 = Integer.parseInt(operand1.split("_")[0]); //gets the whole number of operand1
        	if(wholeN1 < 0) {
        		frac1 [0] = (wholeN1 * (Integer.parseInt(((operand1.split("_")[1]).split("/"))[1]))) - (Integer.parseInt((operand1.split("_")[1]).split("/")[0])); //turns mixed number into improper
        		frac1 [1] = Integer.parseInt((operand1.split("_")[1]).split("/")[1]);//puts denominator of operand1 in array	
        	}
        	else{
        		frac1 [0] = (wholeN1 * (Integer.parseInt(((operand1.split("_")[1]).split("/"))[1]))) + (Integer.parseInt((operand1.split("_")[1]).split("/")[0])); //turns mixed number into improper
        		frac1 [1] = Integer.parseInt((operand1.split("_")[1]).split("/")[1]);//puts denominator of operand1 in array	
        	}
        		
        }
        else {
        	if(operand1.contains("/")) {//checks if it has fraction
        		frac1 [0] = Integer.parseInt(operand1.split("/")[0]); //puts numerator of operand1 in array
        		frac1 [1] = Integer.parseInt(operand1.split("/")[1]);//puts denominator of operand1 in array
        	}
        	else {//no fraction
        		frac1[0] = Integer.parseInt(operand1); //frac1 numerator of array becomes the whole number
        		frac1[1] = 1; //sets frac1 denominator to 1
        	}
        }
        
        if(operand2.contains("_") ) { //checks if it is a mixed number
        	wholeN2 = Integer.parseInt(operand2.split("_")[0]); //gets the whole number of operand2
        	if(wholeN2 < 0) {
        		frac2 [0] = (wholeN2 * (Integer.parseInt(((operand2.split("_")[1]).split("/"))[1]))) - (Integer.parseInt((operand2.split("_")[1]).split("/")[0])); //turns mixed number into improper
        		frac2 [1] = Integer.parseInt((operand2.split("_")[1]).split("/")[1]);//puts denominator of operand2 in array	
        	}
        	else{
        		frac2 [0] = (wholeN2 * (Integer.parseInt(((operand2.split("_")[1]).split("/"))[1]))) + (Integer.parseInt((operand2.split("_")[1]).split("/")[0])); //turns mixed number into improper
        		frac2 [1] = Integer.parseInt((operand2.split("_")[1]).split("/")[1]);//puts denominator of operand2 in array	
        	}
        }
        else {
        	if(operand2.contains("/")) {//checks if it has fraction
        		frac2 [0] = Integer.parseInt(operand2.split("/")[0]); //puts numerator of operand2 in array
        		frac2 [1] = Integer.parseInt(operand2.split("/")[1]);//puts denominator of operand2 in array
        	}
        	else {//no fraction
        		frac2[0] = Integer.parseInt(operand2); //frac2 numerator of array becomes the whole number
        		frac2[1] = 1; //sets frac2 denominator to 1
        	}
        }
     
       //CHECK AND CHOOSE OPERATIONS
       if (operation.equals("+")){
    	   answer = toMixnum(reduce(addition(frac1,frac2)));
       }
       else if(operation.equals("-")) {
    	   answer = toMixnum(reduce(subtraction(frac1,frac2)));
       }
       else if(operation.equals("*")) {
    	   answer = toMixnum(reduce(multiplication(frac1,frac2)));
       }
       else if(operation.equals("/")) {
    	   answer = toMixnum(reduce(division(frac1,frac2)));
       }
        return (answer);
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
   //=========== METHODS USING ARRAYS =========================
    
    public static int[] addition (int[] frac1 , int[] frac2) {
    	int[] answer = new int[2];
    	answer[0]=(frac1[0]*frac2[1]) + (frac2[0] * frac1[1]);
    	answer[1]=(frac1[1] * frac2[1]);
    	return answer;
    }
    
    public static int[] subtraction(int[] frac1, int[] frac2) {
    	int[] answer = new int[2];
    	answer[0]=(frac1[0] * frac2[1]) - (frac2[0] * frac1[1]);
    	answer[1]=(frac1[1] * frac2[1]);
    	return answer;
    }
    
    public static int[] multiplication(int[] frac1, int[] frac2) {
    	int[] answer = new int[2];
    	answer[0] = frac1[0] * frac2[0];
    	answer[1] = frac1[1] * frac2[1];
    	
    	return answer;
    }
    
    public static int[] division(int[] frac1, int[] frac2) {
    	int[] answer = new int[2];
    	answer[0] = frac1[0] * frac2[1];
    	answer[1] = frac1[1] * frac2[0];
    	
    	return answer;
    }
    
    public static int gcd(int a, int b) {//finds the greatest common divisor of the denominator and numerator
    	if(b == 0) {
    		return a;
    	}
    	return gcd(b, a%b);
    }
    
    public static int[] reduce(int[]input) {
    	int divide =gcd(input[0],input[1]); //input the numerator and denominator into the gcd method
    	int[] answer = {(input[0]/divide), (input[1]/divide)}; //divide the numerator and denominator by the gcd
    	return answer; //returns the reduced fraction
    }
    
    public static String toMixnum(int[]reducedfrac) {//mixed number method
    	int numerator = reducedfrac[0];
    	int denominator = reducedfrac[1];    
    	
    	int mixedwholeNum = (numerator/denominator);
    	int remainder = (numerator%denominator);
    	String answer = "";
    	if(denominator < 0) {
    		numerator *=(-1);
    		denominator*=(-1);
    	}


    	if(mixedwholeNum == 0) {
    		if(remainder == 0) {
    			answer = Integer.toString(mixedwholeNum);
    		}
    		else {
    			
    			answer = (remainder + "/" + denominator);
    		}
    	}
    	else {
    		if(remainder == 0) {
    			answer = Integer.toString(mixedwholeNum);
    		}
    		else {
    			if (remainder < 0) {
    				remainder *= (-1);
    			}
    			answer = (mixedwholeNum + "_" + remainder + "/" + denominator);
    		}
    	}
    	
    	
    	return answer;
    }
    
}