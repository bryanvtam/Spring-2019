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

    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	// VARIABLES
        String answers = "";
        String operation = input.split(" ")[1];
        //Initialize objects
        Fraction frac1 = new Fraction(input.split(" ")[0]);
        Fraction frac2 = new Fraction(input.split(" ")[2]);
        frac1.domath(frac1, frac2, operation);
        return answers;
    }
}