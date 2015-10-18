public class StringCalculator{
	
	public static class NegException extends Exception {
		public NegException(String msg){
			super(msg);
		}	
		public NegException() {}
	}

	public static int add(String input) throws NegException {

		if(input.isEmpty()){
			return 0;
		}
		else if(input.charAt(0) == '/'){
			
			int returnValue = 0;
		
			if(input.contains("[")){
				int k = 0;
				String multDelim = "";
				while(input.charAt(k) != '\n'){
					if(input.charAt(k) == '['){
						multDelim += input.charAt(k+1);
						// ef margir eins delim i rod
						if(input.charAt(k+1) == input.charAt(k+2)){
							while(input.charAt(k+1) != ']'){
								k++;
							}	
						}
					}
					k++;
				}
				String multInput = input.substring(k+1);
				String[] token = multInput.split("[" + multDelim + "]" + "+");
				for(int i = 0; i < token.length; i++){
					returnValue += Integer.parseInt(token[i]);
				}
			}
			else{
				String newString = input.substring(4);	
				String[] token = newString.split("[" + input.charAt(2) + "]");

				for(int i = 0; i < token.length; i++){
					returnValue += Integer.parseInt(token[i]);
				}
			}
			return returnValue;
		}
		else if(input.contains(",")){
			String[] token = input.split("[,\n]");
			int returnValue = 0;
			boolean negFound = false;
			String negNumbers = "";
			for(int i = 0; i < token.length; i++){
				int temp = Integer.parseInt(token[i]);
				if(temp < 1000){
					returnValue += Integer.parseInt(token[i]);
				}
				if(temp < 0){
					negFound = true;
					negNumbers += token[i] + ",";
				}
			}
			if(negFound){
				throw new NegException("Negatives not allowed: " + negNumbers);
			}
			return returnValue;
		}
		else{
			return Integer.parseInt(input);
		}		
	}

	public static void main(String[] args){
		
		StringCalculator myCalc = new StringCalculator();
		
		/* Ég skrifaði testin út á skjá og vona að það sé í lagi.
		 * Sá það ekki neinsstaðar í verkefnislýsingunni að maður
		 * þyrfti að nota assert. */

		try{
			// Test fyrir lið 1
			int add = myCalc.add("");
			System.out.println("Hér á að prentast 0");
			System.out.println(add);

			// Test fyrir lið 1
			int add1 = myCalc.add("50");
			System.out.println("\nHér á að prentast 50");
			System.out.println(add1);

			// Test fyrir lið 2
			int add2 = myCalc.add("11,22,10,10,10");
			System.out.println("\nHér á að prentast 63");
			System.out.println(add2);
			
			// Test fyrir lið 3
			int add3 = myCalc.add("1\n2,3,10,10\n10\n10");
			System.out.println("\nHér á að prentast 46");
			System.out.println(add3);
			
			// Test fyrir lið 4
			int add4 = myCalc.add("//;\n1;2;10;10");
			System.out.println("\nHér á að prentast 23");
			System.out.println(add4);
			
			// Test fyrir lið 4
			int add5 = myCalc.add("//=\n2=2=2=2=2");
			System.out.println("\nHér á að prentast 10");
			System.out.println(add5);
			
			// Test fyrir lið 6
			int add6 = myCalc.add("10002,10003,10,1001,999");
			System.out.println("\nHér á að prentast 1009");
			System.out.println(add6);
			
			// Test fyrir lið 7
			int add7 = myCalc.add("//[***]\n1***2***3");
			System.out.println("\nHér á að prentast 6");
			System.out.println(add7);
			
			// Test fyrir lið 7
			int add8 = myCalc.add("//[++++]\n10++++10++++10++++10");
			System.out.println("\nHér á að prentast 40");
			System.out.println(add8);

			// Test fyrir lið 8
			int add9 = myCalc.add("//[*][%][$]\n1*2%3$4");
			System.out.println("\nHér á að prentast 10");
			System.out.println(add9);
			
			// Test fyrir lið 9
			int add10 = myCalc.add("//[***][%%%%%][}}}]\n10%%%%%10}}}10***10***10");
			System.out.println("\nHér á að prentast 50");
			System.out.println(add10);
			
			// Test fyrir lið 5
			int addTEST = myCalc.add("1,3,4,-2,-3,-5");
		}
		catch(NegException ex){
			ex.printStackTrace();
		}
	}
}
