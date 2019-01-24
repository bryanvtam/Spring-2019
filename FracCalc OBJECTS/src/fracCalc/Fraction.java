package fracCalc;

public class Fraction {

		private int numerator;
		private int denominator;
		private int whole;
		private int[] frac = {whole, numerator, denominator};
		private int sign;
		
		public Fraction() {
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
		}
		
		public void toImproper() {
			if (whole != 0) {
				numerator = sign*(numerator + (whole * denominator));
			}	
		}
		
		public static 
}
