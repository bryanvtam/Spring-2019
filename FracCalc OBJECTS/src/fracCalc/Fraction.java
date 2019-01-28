package fracCalc;

public class Fraction {

		private int numerator;
		private int denominator;
		private int whole;
		private int sign;
		
		public Fraction() { //Initializes the values of the instances
			numerator = 0;
			denominator = 1;
			whole = 0;
			sign = 1;
		}
		
		public Fraction (String op) { //fraction constructor
			//finds the numerator, denominator, and whole number of the operand
			sign = 1;
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
			
			//determines if it the sign of the fraction, negative or positive
			if(numerator < 0) {
				sign = -1;
				numerator *= -1;
			}
			else if (whole < 0) {
				sign = -1;
				whole *= -1;
			}
			System.out.println(whole + "," + numerator + "," + denominator + "," + sign);
		}
		
		public void toImproper() {
			if (whole != 0) {
				numerator = sign*(numerator + (whole * denominator));
				whole = 0;
				sign = 1;
			}	
		}
		
		public void reduce() {
			int min = numerator;
			int divisor = 1;
			
			if(numerator > denominator) {
				min = denominator;
			}
			
			for(int i = 1; i <= min; i++) {
				if(numerator%i == 0 && denominator%i == 0) {
					divisor = i;
				}
				i++;
			}
			numerator /= divisor;
			denominator /= divisor;
		}
		
		public void toMixed() {
			reduce();
			
			if((numerator / denominator) != 0) {
				whole = (numerator / denominator);
				if(numerator < 0 ) {
					numerator *= -1;
					numerator = (numerator % denominator);
				}
			}
		}
		
		
		
		public String toString(Fraction input) {
			String answer ="";
			
			if(input.whole !=0) {
				answer += whole;
				if(input.numerator != 0 ) {
					answer += "_" + numerator + "/" + denominator;
				}
			}
			else {
				if(numerator == 0 ) {
					answer = "0";
				}
				else {
					answer += numerator + "/" + denominator;
				}
			}
			System.out.println(answer);
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
				answer.denominator = frac1.denominator * frac1.denominator;
			}
			else if (operation.equals("*")) {
				answer.numerator = (frac1.numerator * frac2.numerator);
				answer.denominator = (frac1.denominator * frac2.denominator);
			}
			else if (operation.equals("/")) {
				answer.numerator = (frac1.numerator * frac2.denominator);
				answer.denominator = (frac1.denominator * frac2.numerator);
			}
			answer.toMixed();
		}
		
}