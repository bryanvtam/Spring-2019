package fracCalc;

public class Fraction {

		private int numerator;
		private int denominator;
		private int whole;
		
		public Fraction() { //Initializes the values of the instances
			numerator = 0;
			denominator = 1;
			whole = 0;
		}
		
		public Fraction (String op) { //fraction constructor
			//finds the numerator, denominator, and whole number of the operand
			if (op.contains("_")) {
				whole = Integer.parseInt((op.split("_"))[0]);
				numerator = Integer.parseInt((op.split("_")[1]).split("/")[0]);
				denominator = Integer.parseInt((op.split("_")[1].split("/")[1]));
			}
			else {
				if(op.contains("/")) {
					numerator = Integer.parseInt(op.split("/")[0]);
					denominator = Integer.parseInt(op.split("/")[1]);
				}
				else {
					whole = Integer.parseInt(op);
				}
			}
		}
		
		public void toImproper() {
			if (whole != 0) {
				if(whole < 0) {
					numerator = (-numerator +(whole * denominator));
				}
				else {
				numerator = (numerator + (whole * denominator));
				}
				whole = 0;
			}
		}
		
		public void reduce() {
			int divisor = 1;
			
			if(numerator % denominator == 0) {
				whole = numerator / denominator;
				numerator = 0;
			}
			else {
				divisor = gcd(numerator,denominator);
				numerator /= divisor;
				denominator /= divisor;
			}
			
			if(denominator < 0) {
				numerator *= -1;
				denominator *= -1;
			}
		}
		
		 public static int gcd(int a, int b) {//finds the greatest common divisor of the denominator and numerator
		    	if(b == 0) {
		    		return a;
		    	}
		    	return gcd(b, a%b);
		    }
		
		 public void toMixed() {
				
				if((numerator / denominator) != 0) {
					whole = (numerator / denominator);
					if(numerator < 0 ) {
						numerator *= -1;
						numerator = (numerator % denominator);
					}
					else {
						numerator = (numerator % denominator);
					}
				}
			}
		 
		public String toString() {
			String answer = "";
			if(whole !=0) {
				answer+= whole;
				if(numerator != 0) {
					answer += "_" + numerator + "/" + denominator;
				}
			}
			else {
				if(numerator == 0) {
					answer ="0";
				}
				else {
					answer += numerator +"/" + denominator;
				}
			}
			return answer;
		}
		
		

		public void domath(Fraction frac1, Fraction frac2 , String operation) {
			frac1.toImproper();
			frac2.toImproper();
			Fraction answer = new Fraction();
			
			if (operation.equals("+")) {
				answer.numerator = (frac1.numerator * frac2.denominator) + (frac2.numerator * frac1.denominator);
				answer.denominator = frac1.denominator * frac2.denominator;
			}
			else if (operation.equals("-")) {
				answer.numerator = (frac1.numerator * frac2.denominator) - (frac2.numerator * frac1.denominator);
				answer.denominator = frac1.denominator * frac2.denominator;
			}
			else if (operation.equals("*")) {
				answer.numerator = (frac1.numerator * frac2.numerator);
				answer.denominator = (frac1.denominator * frac2.denominator);
			}
			else if (operation.equals("/")) {
				answer.numerator = (frac1.numerator * frac2.denominator);
				answer.denominator = (frac1.denominator * frac2.numerator);
			}
			answer.reduce();
			answer.toMixed();
			System.out.println (answer.toString());
		}
		
}