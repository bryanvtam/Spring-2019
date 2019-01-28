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
		
		public void reduce(Fraction unreduced) {
			
		}
		
		public void toMixed(Fraction impropFrac) {
			
			
			if((impropFrac.numerator / impropFrac.denominator) != 0) {
				impropFrac.whole = (impropFrac.numerator / impropFrac.denominator);
				if(impropFrac.numerator < 0 ) {
					impropFrac.numerator *= -1;
					impropFrac.numerator = (impropFrac.numerator % impropFrac.denominator);
				}
			}
		}
		
		
		
		public String toString (int[] answerArray) {
			String answer = "";
			
			if(answerArray[0] != 0 ) {
				answer += answerArray[0];
				if(answerArray[1] != 0) {
					answer += "_" + answerArray[1] + "/" + answerArray[2];
				}
			}
			else if (answerArray[0] == 0 && answerArray[1] == 0){
				answer += 0;
			}
			else {
				answer += answerArray[1] + "/" + answerArray[2];
			}
			return answer;
		}


		public static void domath(Fraction frac1, Fraction frac2 , String operation) {
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
			
			
			
		}
}