public class StringCalculator{

	public static class NegException extends Exception {
		public NegException(String msg){
			super(msg);
		}	
	}

	public static int add(String input) {

		if(input.contains("-")) {
			//throw new NegException("Negatives not allowed: ");
			String[] token = input.split("[,]");
			String negNumbers = "";
			for(int i = 0; i < token.length; i++){
				int temp = Integer.parseInt(token[i]);
				if(temp < 0){
					negNumbers += token[i] + ",";
				}
			}
			// muna að kasta Exception hérna
			System.out.print("\nNegatives not allowed: ");
			System.out.print(negNumbers + "\n");
			return 0;
		}
		else if(input.isEmpty()){
			return 0;
		}
		else if(input.charAt(0) == '/'){
			int returnValue = 0;
			if(input.contains("[")){
				int lo = 0, hi = 0;
				while(input.charAt(hi) != ']'){
					if(input.charAt(hi) == '['){
						lo = hi;
					}
					hi++;
				}
				String delimiter = input.substring(lo+1,hi);
				//System.out.print("delimiter--------->" + delimiter);
				int cutter = delimiter.length() + 5;
				//String splitInput = "\"" + "[" + delimiter.charAt(0) + "]" + "+" + "\"";
				//System.out.print("Split Input--------> " + splitInput + "\n");
				String newInput = input.substring(cutter);
				//System.out.print("InputString-------->" + newInput + "\n");
				String[] token = newInput.split("[" + delimiter.charAt(0) + "]+");
				//System.out.print("token0----------->" + token[0] + "\n");
				//System.out.print("token1----------->" + token[1] + "\n");

				for(int i = 0; i < token.length; i++){
					returnValue += Integer.parseInt(token[i]);
				}
				//System.out.print("---------------> " + delimiter + "\n");
			}
			else{
				String newString = input.substring(4);	
				String[] token = newString.split("[;]");

				for(int i = 0; i < token.length; i++){
					returnValue += Integer.parseInt(token[i]);
				}
			}
			return returnValue;
		}
		else if(input.contains(",")){
			String[] token = input.split("[,\n]");
			int returnValue = 0;

			for(int i = 0; i < token.length; i++){
				int temp = Integer.parseInt(token[i]);
				if(temp < 1000){
					returnValue += Integer.parseInt(token[i]);
				}
			}
			return returnValue;
		}
		else{
			return Integer.parseInt(input);
		}		
	}

	public static void main(String[] args){
		StringCalculator myCalc = new StringCalculator();

		int add = myCalc.add("11,22,10,10,10");
		System.out.println("Hér á að prentast 63");
		System.out.println(add);

		int add1 = myCalc.add("50");
		System.out.println("\nHér á að prentast 50");
		System.out.println(add1);

		int add2 = myCalc.add("");
		System.out.println("\nHér á að prentast 0");
		System.out.println(add2);

		int add3 = myCalc.add("1\n2,3,10,10\n10\n10");
		System.out.println("\nHér á að prentast 46");
		System.out.println(add3);

		int add4 = myCalc.add("//;\n1;2;10;10");
		System.out.println("\nHér á að prentast 23");
		System.out.println(add4);

		int add5 = myCalc.add("8,-2,6,-4,2,-6");

		int add6 = myCalc.add("10002,10003,10,1001,999");
		System.out.println("\nHér á að prentast 1009");
		System.out.println(add6);

		int add7 = myCalc.add("//[***]\n1***2***3");
		System.out.println("\nHér á að prentast 6");
		System.out.println(add7);

		int add8 = myCalc.add("//[++++]\n10++++10++++10++++10");
		System.out.println("\nHér á að prentast 40");
		System.out.println(add8);
	}
}
